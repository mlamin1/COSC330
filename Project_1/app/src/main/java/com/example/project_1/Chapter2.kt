package com.example.project_1

import android.content.Context
import androidx.annotation.RawRes
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.*

import org.akop.ararat.core.Crossword
import org.akop.ararat.core.buildCrossword
import org.akop.ararat.io.PuzFormatter
import org.akop.ararat.view.CrosswordView


class Chapter2 : AppCompatActivity(), CrosswordView.OnLongPressListener, CrosswordView.OnStateChangeListener, CrosswordView.OnSelectionChangeListener {

    private var crosswordView: CrosswordView? = null
    private var hint: TextView? = null
    private var toast: Toast? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_chapter_2)

        crosswordView = findViewById(R.id.crossword)
        hint = findViewById(R.id.hint)

        val crossword = readPuzzle(R.raw.wellness)

        title = getString(R.string.title_by_author,
                crossword.title, crossword.author)

        crosswordView!!.let { cv ->
            cv.crossword = crossword
            cv.setOnLongPressListener(this)
            cv.setOnStateChangeListener(this)
            cv.setOnSelectionChangeListener(this)
            cv.setInputValidator { ch -> !ch.first().isISOControl() }
            cv.undoMode = CrosswordView.UNDO_NONE
            cv.markerDisplayMode = CrosswordView.MARKER_CHEAT
            showSoftKeyboard(cv)

            onSelectionChanged(cv, cv.selectedWord, cv.selectedCell)
        }
    }
    fun showSoftKeyboard(view: CrosswordView) {
        if (view.requestFocus()) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        crosswordView!!.restoreState(savedInstanceState.getParcelable("state")!!)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putParcelable("state", crosswordView!!.state)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.cross, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_restart -> {
                crosswordView!!.reset()
                return true
            }
            R.id.menu_solve_cell -> {
                crosswordView!!.solveChar(crosswordView!!.selectedWord!!,
                        crosswordView!!.selectedCell)
                return true
            }
            R.id.menu_solve_word -> {
                crosswordView!!.solveWord(crosswordView!!.selectedWord!!)
                return true
            }
            R.id.menu_solve_puzzle -> {
                crosswordView!!.solveCrossword()
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onCellLongPressed(view: CrosswordView, word: Crossword.Word, cell: Int) {
        toast = makeText(this, "First letter hint: " + view.selectedWord[0].toString(),
                LENGTH_SHORT)
        toast?.setGravity(Gravity.TOP, 0, 200)
        toast?.show()
    }

    override fun onCrosswordChanged(view: CrosswordView) {}

    override fun onCrosswordSolved(view: CrosswordView) {
        toast = makeText(this, R.string.youve_solved_the_puzzle,
                LENGTH_SHORT)
        toast?.setGravity(Gravity.TOP, 0, 200)
        toast?.show()
    }

    override fun onCrosswordUnsolved(view: CrosswordView) {
    }

    private fun readPuzzle(@RawRes resourceId: Int): Crossword =
            resources.openRawResource(resourceId).use { s ->
                buildCrossword { PuzFormatter().read(this, s) }
            }

    override fun onSelectionChanged(view: CrosswordView, word: Crossword.Word?, position: Int) {

        if(view.selectedWord[0].toString().equals("V")) {
            hint!!.text = getString(R.string.down, word?.number, "Found in foods that help your body stay healthy.")
        }
        else if(view.selectedWord[0].toString().equals("E")) {
            hint!!.text = getString(R.string.down, word?.number, "You should _______ regularly to help your heart stay strong.")
        }
        else if(view.selectedWord[0].toString().equals("C")) {
            hint!!.text = when (word?.direction) {
                Crossword.Word.DIR_ACROSS -> getString(R.string.across, word.number, "This is a type of food that should be limited if you have diabetes. When eaten it is broken down into sugar. Bread has a large amount of these.")
                Crossword.Word.DIR_DOWN -> getString(R.string.down, word.number, "Too much sugar is bad for you, as it has lots of __________, which causes weight gain, diabetes and does not give your body energy.")
                else -> ""
            }
        }
        else if(view.selectedWord[0].toString().equals("O")) {
            hint!!.text = getString(R.string.down, word?.number, "This word means a person is very overweight and will not be healthy.")
        }
        else if(view.selectedWord[0].toString().equals("S")) {
            hint!!.text = getString(R.string.down, word?.number, "Another name for salt.")
        }
        else if(view.selectedWord[0].toString().equals("F")) {
            hint!!.text = getString(R.string.down, word?.number, "Apples, bananas and oranges are called this.")
        }
        else if(view.selectedWord[0].toString().equals("D")) {
            hint!!.text = getString(R.string.down, word?.number, "A disease that causes high level of glucose/sugar in your body, leading to serious health problems.")
        }
        else
            hint!!.text = " "
        /*
        hint!!.text = when (word?.direction) {
            Crossword.Word.DIR_ACROSS -> getString(R.string.across, word.number, word.hint)
            Crossword.Word.DIR_DOWN -> getString(R.string.down, word.number, word.hint)
            else -> ""
        }
         */
    }
}