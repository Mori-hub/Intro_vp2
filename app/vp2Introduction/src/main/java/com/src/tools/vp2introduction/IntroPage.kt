package com.src.tools.vp2introduction

import android.app.Activity
import android.content.Context
import android.content.res.Configuration
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2


var imagesNow = ArrayList<Int>()
var titlePage = ArrayList<String>()
var desPage = ArrayList<String>()
var backgroundPage = ArrayList<Int>()
var titleSizePage = ArrayList<Float>()
var textSizePage = ArrayList<Float>()
var textColorPage = ArrayList<Int>()
var titleColorPage = ArrayList<Int>()


var runningFunctions: (() -> Unit)? = null
var textDone = "Done"
var colorDone = Color.LTGRAY
var themeTranslucentDecor = true
var wTheme = 1
var finishThis = false
var viewPager2: ViewPager2? = null
var activity: Activity? = null
    get() = field
    set(value) {
        field = value
    }
var t: ViewPager2.PageTransformer? = null
var v: Boolean = false

class IntroPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        when (wTheme) {
            0 -> this.setTheme(android.R.style.Theme_Wallpaper_NoTitleBar_Fullscreen)
            1 -> this.setTheme(android.R.style.Theme_DeviceDefault_NoActionBar_TranslucentDecor)
            2 -> this.setTheme(android.R.style.Theme_Black_NoTitleBar)
            3 -> this.setTheme(android.R.style.Theme_Material_NoActionBar_TranslucentDecor)

        }

        supportActionBar?.hide()

        setContentView(R.layout.activity_intro_page)
        viewPager2 = findViewById(R.id.introViewPage)

        val viewPager2Adapter = ViewPager2Adapter(this, viewPager2 as ViewPager2)
        viewPager2?.setPageTransformer(t)
        if (v) viewPager2?.orientation = ViewPager2.ORIENTATION_VERTICAL
        viewPager2?.adapter = viewPager2Adapter
        activity = this

    }


    // Constructor of our ViewPager2Adapter class
    class ViewPager2Adapter
        (private val ctx: Context, private val viewPager2: ViewPager2) :
        RecyclerView.Adapter<ViewPager2Adapter.ViewHolder>() {

        class SetPages {
            var image = 0
                set(value) {
                    field =
                        if (value > 0) value else throw IllegalArgumentException("Add from Drawable ")
                    imagesNow.add(field)
                    addHow()

                }
            var title = "No Title"
                set(value) {
                    titlePage.removeLast()
                    titlePage.add(value)

                }
            var description = "No Desc"
                get() {
                    return field.trim()
                }
                set(value) {
                    field = value
                    desPage.removeLast()
                    desPage.add(field)

                }
            var background = 0
                set(value) {
                    field = value
                    backgroundPage.removeLast()
                    backgroundPage.add(value)
                     
                }
            var titleSize = 0F
                set(value) {
                    field = value
                    titleSizePage.removeLast()
                    titleSizePage.add(value)
                     
                }
            var textSize = 0F
                set(value) {
                    field = value
                    textSizePage.removeLast()
                    textSizePage.add(value)
                     
                }
            var titleColor = 0
                set(value) {
                    field = value
                    titleColorPage.removeLast()
                    titleColorPage.add(value)
                     
                }
            var textColor = 0
                set(value) {
                    field = value
                    textColorPage.removeLast()
                    textColorPage.add(value)
                     
                }
            private fun addHow() {
                desPage.add("No Desc")
                titlePage.add("No Title")
                backgroundPage.add(Color.GRAY)
                // Add More 
                titleSizePage.add(40F)
                textSizePage.add(18F)
                titleColorPage.add(Color.BLACK)
                textColorPage.add(Color.BLACK)
            }

            fun done(
                text: String,
                colorBtn: Int,
                running: (() -> Unit)? = null,
                finish: Boolean = false
            ) {
                textDone = text
                colorDone = colorBtn
                runningFunctions = running
                finishThis = finish

            }

            fun theme(whichTheme: Int) {
                wTheme = whichTheme
            }

            fun transformer(takeTrans: ViewPager2.PageTransformer, vertical: Boolean = false) {
                t = takeTrans
                v = vertical
            }
        }


        // This method returns our layout
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view: View = LayoutInflater.from(ctx).inflate(R.layout.images_holder, parent, false)

            // Find Real Size
            val configuration: Configuration = ctx.resources.configuration
            configuration.screenHeightDp
            if (parent.height <= ctx.resources.displayMetrics.heightPixels)
                themeTranslucentDecor = false
          return ViewHolder(view)
        }

        // This method binds the screen with the view
        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            // Control for FullScreen
            val params = holder.tvNext.layoutParams as ViewGroup.MarginLayoutParams
            if (themeTranslucentDecor) params.bottomMargin = 70
            else holder.cvNext.layoutParams.height = 200

            // Next by click on Button
            holder.cvNext.setOnClickListener {
                val currPos: Int = viewPager2.currentItem
                if ((currPos + 1) != viewPager2.adapter?.itemCount) {
                    viewPager2.currentItem = currPos + 1
                }
            }
            holder.mainBody.setBackgroundColor(backgroundPage[position])
            holder.images.setImageResource(imagesNow[position])
            holder.tvTitle.text = titlePage[position]
            holder.tvTitle.textSize= titleSizePage[position]
            holder.tvTitle.setTextColor(titleColorPage[position])

            holder.tvDes.text = desPage[position]
            holder.tvDes.textSize= textSizePage[position]
            holder.tvDes.setTextColor(textColorPage[position])



            if (titlePage.lastIndex != position) {
                holder.tvNext.text = titlePage[position + 1]
                holder.tvNext.setTextColor(titleColorPage[position+ 1])
            }

            // Last Page
            if (backgroundPage.lastIndex != position)
                holder.cvNext.setCardBackgroundColor(backgroundPage[position + 1])
            else {
                holder.cvNext.setCardBackgroundColor(colorDone)
                holder.tvNext.text = textDone
                holder.cvNext.setOnClickListener {
                    runningFunctions?.invoke()
                    holder.cvNext.animate().translationY((holder.cvNext.height).toFloat())
                    if (finishThis)
                        activity?.finish()
                }

            }
        }

        // This Method returns the size of the Array
        override fun getItemCount(): Int {

            return imagesNow.size
        }

        // The ViewHolder class holds the view
        class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            var mainBody: LinearLayout = itemView.findViewById(R.id.mainBody)
            var images: ImageView = itemView.findViewById(R.id.images)
            var tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
            var tvDes: TextView = itemView.findViewById(R.id.tvDes)
            var tvNext: TextView = itemView.findViewById(R.id.tvNext)
            var cvNext: CardView = itemView.findViewById(R.id.cvNext)
        }

    }
}
