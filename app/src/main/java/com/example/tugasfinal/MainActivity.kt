package com.example.tugasfinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tugasfinal.User.PenumpangEntity
import com.example.tugasfinal.User.UserViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dialog_layout.view.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private lateinit var viewmodel : UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewmodel = ViewModelProvider(this).get(UserViewModel::class.java)
        recyclerview.setHasFixedSize(true)
        recyclerview.layoutManager = LinearLayoutManager(this)

        viewmodel.getPenumpang()?.observe(this, Observer {
            recyclerview.adapter = MainAdapter(it, object : MainAdapter.Listener{
                override fun onViewClick(penumpangEntity: PenumpangEntity) {
                    onViewAction(penumpangEntity)
                }
            })
        })

        addBtn.setOnClickListener {
            showAddDialog()
        }

    }

    private fun onViewAction(penumpangEntity: PenumpangEntity) {
        TODO("Not yet implemented")
    }

    private fun showAddDialog() {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.dialog_layout, null)
        val builder = this.let {
            AlertDialog.Builder(it)
                .setView(dialogView)
        }
        val mDialog = builder?.show()
        dialogView.close_btn.setOnClickListener {
            mDialog?.dismiss()
        }
        dialogView.btn.setOnClickListener {
            try {
                with(dialogView) {
                    viewmodel.insertPenumpang(
                        PenumpangEntity(
                            0, namaET.text.toString(), umurET.text.toString(), jeniskelamin(this), alamatET.text.toString(), tempat_keberangkatanET.text.toString(), tujuan_keberangkatanET.text.toString()
                        )
                    )
                }
                mDialog?.dismiss()
                Toast.makeText(this, "Data Beerhasil Disimpan", Toast.LENGTH_SHORT).show()
            } catch (e: Exception) {
                mDialog?.dismiss()
                Toast.makeText(this, "Data Gagal Disimpan", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun jeniskelamin(view: View): String {
        return when(view.radiogroup.checkedRadioButtonId) {
            R.id.lakilaki -> "Laki-laki"
            R.id.perempuan -> "Perempuan"
            else -> ""
        }
    }
}