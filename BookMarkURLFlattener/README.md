Made March 2017

How to use ant. You need Apache ant. 
The build.xml file has a bunch of set commands created.



$ ant clean 		will clean the \out\ dir
$ ant build.modules 	will compile everything
$ ant build.all.artifacts will compile, and then build the executable jar and then put in \out\artifacts\, along with the other jars that are used
