# StickyHeader

A module is added for sticky header we can customize it according our requirements
Usage
-----

1. Add mavenCentral() to repositories block in the gradle file.
2. Add `implementation 'com.github.shuhart:stickyheader:1.1.0` to the dependencies.
3. Look into the sample for additional details on how to use and configure the library.

Then, attach it to the RecyclerView:
How it works
-----
* A ViewHolder is created by the adapter to reuse and bind every header.
* A header view is drawn on top of the RecyclerView using onDrawOver() callback of ItemDecoration.


Currently I have built this only for demo so I directly assigned values to list in adapter we can improve it in another way also. 
View can also be changed we just have to define type for view rendering
