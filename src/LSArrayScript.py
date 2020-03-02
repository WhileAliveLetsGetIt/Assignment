#Python programme to run java commands for load shedding applications
#Calvin Nyoni
#2 March 2018

import subprocess

print(subprocess.call(["javac", "LSArrayApp.java"]))
print(subprocess.call(["java", "LSArrayApp"]))

