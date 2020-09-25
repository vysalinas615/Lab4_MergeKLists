Name: Victoria Salinas

Section: CS 245-01

Date: 09/24/2020

How to run it: 

1) Pass in your own values in the main using a double[][] named outerArray. (I commented out a few examples of different sizes if you would like to use those. Please enter your values in the asterisked section that I made.) 

2) Once you enter your values and compile it, he program will then ask you for the numer of inner arrays and the number of total individual items. Please enter those, and then it should do everything else automatically. 

Notes for TA: 

I could not fully use merge sort in order to sort the items in the split arrays because one of the parameters for mergeKLists was that it only took in a double[][] (2D) array, and in order for my program to successfully recursively call mergeKLists once the arrays were split I would need to pass in a double[] not a double[][]. 

I used insertion sort to sort the split arrays instead. I did merge the items together using the basic concept of what merge sort should do.

The code produces the iutput that it should however. Another thing I had a little trouble with was printing the original 2D array. On the last item it will sometimes leave a comma after it and before the last "}", and that bugged me a bit. 