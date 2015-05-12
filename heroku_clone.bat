@echo on

echo %2

cd %2
echo xcopy "%1/stampidia/src" "%2/%3/src" /E /Y

heroku git:clone -a %3
