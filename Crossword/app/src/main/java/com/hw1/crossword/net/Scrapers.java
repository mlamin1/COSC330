package com.totsp.crossword.net;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

import com.totsp.crossword.PlayActivity;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class Scrapers {
    private ArrayList<AbstractPageScraper> scrapers = new ArrayList<AbstractPageScraper>();
    private Context context;
    private NotificationManager notificationManager;
    private boolean supressMessages;

    public Scrapers(SharedPreferences prefs, NotificationManager notificationManager, Context context) {
        this.notificationManager = notificationManager;
        this.context = context;

        //        if (prefs.getBoolean("scrapeBEQ", true)) {
        //            scrapers.add(new BEQuigleyScraper());
        //        }
        System.out.println("scrapeCru" + prefs.getBoolean("scrapeCru", false));

        if (prefs.getBoolean("scrapeCru", false)) {
            scrapers.add(new CruScraper());
        }

        if (prefs.getBoolean("scrapeKegler", false)) {
            scrapers.add(new KeglerScraper());
        }
        
//        if (prefs.getBoolean("scrapePeople", true)) {
//            scrapers.add(new PeopleScraper());
//        }

        this.supressMessages = prefs.getBoolean("supressMessages", false);
    }

    public void scrape() {
        int i = 1;
        String contentTitle = "Downloading Scrape Puzzles";

        NotificationCompat.Builder not = new NotificationCompat.Builder(context)
                .setSmallIcon(android.R.drawable.stat_sys_download)
                .setContentTitle(contentTitle)
                .setWhen(System.currentTimeMillis());

        for (AbstractPageScraper scraper : scrapers) {
            try {
                String contentText = "Downloading from " + scraper.getSourceName();
                Intent notificationIntent = new Intent(context, PlayActivity.class);
                PendingIntent contentIntent = PendingIntent.getActivity(context, 0, notificationIntent, 0);
                not.setContentText(contentText).setContentIntent(contentIntent);

                if (!this.supressMessages && this.notificationManager != null) {
                    this.notificationManager.notify(0, not.build());
                }

                List<File> downloaded = scraper.scrape();

                if (!this.supressMessages) {
                    for (File f : downloaded) {
                        postDownloadedNotification(i++, scraper.getSourceName(), f);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (this.notificationManager != null) {
            this.notificationManager.cancel(0);
        }
    }

    public void supressMessages(boolean b) {
        this.supressMessages = b;
    }

    private void postDownloadedNotification(int i, String name, File puzFile) {
        String contentTitle = "Downloaded Puzzle From " + name;

        Intent notificationIntent = new Intent(Intent.ACTION_EDIT, Uri.fromFile(puzFile), context, PlayActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(context, 0, notificationIntent, 0);

        Notification not = new NotificationCompat.Builder(context)
                .setSmallIcon(android.R.drawable.stat_sys_download_done)
                .setContentTitle(contentTitle)
                .setContentText(puzFile.getName())
                .setContentIntent(contentIntent)
                .setWhen(System.currentTimeMillis())
                .build();

        if (this.notificationManager != null) {
            this.notificationManager.notify(i, not);
        }
    }
}
