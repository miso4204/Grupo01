cd %2/%3

xcopy "%1/stampidia/src" "%2/%3/src" /E /Y
git add .
git commit -am "make it better"
git push heroku master
