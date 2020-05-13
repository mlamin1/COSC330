#! python3
#import pandas as pd
#from alpha_vantage.timeseries import TimeSeries
#import time

def testing():
    api_key = 'Q4XEK6ZUXET8G86P'

    #ts = TimeSeries(key=api_key, output_format='pandas')
    #data, meta_data = ts.get_intraday(symbol='MSFT', interval = '1min', outputsize = 'compact')
    #print(data)

    #i = 1
    #while i==1:
    #    data, meta_data = ts.get_intraday(symbol='MSFT', interval = '1min', outputsize = 'full')
    #    data.to_excel("output.xlsx")
    #    time.sleep(60)

    #close_data = data['4. close']
    #percentage_change = close_data.pct_change()

    #print(percentage_change)
    return api_key
#print(testing())
