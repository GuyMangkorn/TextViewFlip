# TextView-Flip [![TextView-Flip](https://jitpack.io/v/sotgame1234/textView-flip.svg)](https://jitpack.io/#sotgame1234/textView-flip)
### Example:

<img src="/resource/anim_main.gif" style="width: 30%;">

#### Gradle:
```
  allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
 ```

 #### Dependency:
 ```
  dependencies {
	        implementation 'com.github.sotgame1234:textView-flip:TAG-Version'
	}
 ```

#### Layout XML:
 ```
 <com.example.marquee_vertical.MarqueeVertical
       android:layout_marginTop="10dp"
       android:id="@+id/textFlip"
       android:layout_width="match_parent"
       android:layout_height="wrap_content"
       app:mqvTextGravity="center"
       app:mqvTextStyle="bold"
       app:mqvInterval="1000"
       app:mqvScrollFadeDuration="500"
       app:mqvTextColor="#B54646"
       app:mqvTextSize="35dp"/>
 ```
 #### Attribute:
| Attribute    | Description  |
|:---		|:---| 
|mqvTextGravity| to set TextView gravity : center,start,end,bottom|
|mqvTextStyle | to set TextStyle : bold,italic,normal|
|mqvInterval | to set flip Interval : Default is 3000|
|mqvScrollFadeDuration | to set FadeDuration : Default is 1500|
|mqvTextColor | to set TextColor|
|mqvTextSize | to set TextSize : default is 14sp| 
