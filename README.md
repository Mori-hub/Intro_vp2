
# Introduction App

This lib helps to introduce the App-by view page based on Kotlin.
## Features

- Easy Set up
- Items: Title, Describe, Background, Buttons
- Apply : Vertical and horizontal
- Code : Kotlin
- Transformer : Add yours or use another Libs
- Performance as an Activity


## 📚Installation

Install my-project with https://jitpack.io/

```bash
  dependencies {
	        implementation 'com.github.Mori-hub:'
	}
```
    
## 🧰Usage


* First add Activity in Manifest
```javascript
   <activity android:name="com.src.tools.vp2introduction.IntroPage"/>
```
* Intent from your Activity 
```javascript
   this.startActivity(Intent(this, IntroPage::class.java))
```
* Finaly Call 

```javascript
   val items = IntroPage.ViewPager2Adapter.SetPages()        
```


## 🎭Structure
```javascript
 val item = IntroPage.ViewPager2Adapter.SetPages()
        item.image = R.drawable.
        item.title = String
        item.description =String
        item.background = Color.parseColor("#")
        item.titleColor=Color.
        item.textColor= R.color.
        item.textSize=Float 
        item.titleSize=Float
```   
## Examples
```javascript
 val item4 = IntroPage.ViewPager2Adapter.SetPages()
        item4.image = android.R.drawable.checkbox_on_background
        item4.title = "Item Four"
        item4.description ="🎭 getString(R.string.app_desc)"
        item4.background = Color.parseColor("#125B50")
        item4.titleColor=Color.parseColor("#F7FF93")
        item4.textColor=Color.parseColor("#E4AEC5")
        item4.textSize=20f
        item4.titleSize=30f
```

## 🎨 More Options
You can control Themes, Directions and Done button

## Done Button
When it reaches the last page
```javascript
val all = IntroPage.ViewPager2Adapter.SetPages()

all.done( "So Good", Color.parseColor("#FF6363") , 
         {Toast.makeText(this, "getString(R.string.now_lets_start)", Toast.LENGTH_SHORT).show()} , true)
     
``` 
Attention: Function must be on {} as an Unit, the last parameters ask about finish after all (true/false).

## Set Theme
There are 4 themes inside of this lib, you can set one of them if you need.

```javascript
 0 -> this.setTheme(android.R.style.Theme_Wallpaper_NoTitleBar_Fullscreen)
 1 -> this.setTheme(android.R.style.Theme_DeviceDefault_NoActionBar_TranslucentDecor)
 2 -> this.setTheme(android.R.style.Theme_Black_NoTitleBar)
 3 -> this.setTheme(android.R.style.Theme_Material_NoActionBar_TranslucentDecor)
  
```
Now Put a numer in this line :
```javascript
   all.theme(1)
```
## Set Transformer
If you want to add a page Transformer put on the first parameter and vertical direction on the second parameter

```javascript
 all.transformer(here),t/f)
```
Like this :
```javascript
  all.transformer(Transfer.RotateDown(),true)
```
Here it's used anther lib for Tranformation
```javascript
  implementation 'com.github.Mori-hub:ViewPager2_Transfer:1.0.0'
```

## Screenshots


## Gifs



## 🖐Important Notic
Please add parameters due to number of icons, otherwise the app will crash and close.

## 🚀 About Me
I'm a full stack developer...


## 🛠 Skills
Java, Kotlin, CSS....


## Tech Stack

**Important:** For Gradle 7.2 & jitpack.io Please use this way : https://stackoverflow.com/a/71603699/12272687

**Update:** March 2022


## 🔗 Links
[![portfolio](https://img.shields.io/badge/my_portfolio-000?style=for-the-badge&logo=ko-fi&logoColor=white)](https://github.com/Mori-hub)
[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/)
[![twitter](https://img.shields.io/badge/twitter-1DA1F2?style=for-the-badge&logo=twitter&logoColor=white)](https://twitter.com/)
[![Google](https://img.shields.io/badge/My%20Apps-Google%20Play%20Store-green?style=for-the-badge&logo=googleplay)](https://play.google.com/store/search?q=pub:Smart%20rabit&c=apps)

## Feedback

If you have any feedback, please reach out to us at SR-App@outlook.com


## License

[MIT](https://choosealicense.com/licenses/mit/)

