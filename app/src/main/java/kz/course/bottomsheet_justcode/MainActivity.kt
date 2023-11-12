package kz.course.bottomsheet_justcode

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.view.Window
import android.widget.ImageView
import kz.course.bottomsheet_justcode.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)


        setContentView(binding.root)



        binding.station1.setOnClickListener {
            showBottomDialog(R.drawable.img_4)
        }

        binding.station2.setOnClickListener {
            showBottomDialog(R.drawable.img_1)
        }

        binding.station3.setOnClickListener {
            showBottomDialog(R.drawable.img_2)
        }



    }

    private fun showBottomDialog(imageResId: Int) {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.bottomsheet)

        val stationImage = dialog.findViewById<ImageView>(R.id.stationImage)

        // Устанавливаем изображение согласно переданному ресурсу
        stationImage.setImageResource(imageResId)

        dialog.show()
        dialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.window?.attributes?.windowAnimations = R.style.DialogAnimation
        dialog.window?.setGravity(Gravity.BOTTOM)
    }

}