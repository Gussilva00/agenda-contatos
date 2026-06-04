@REM ----------------------------------------------------------------------------
@REM Maven Start Up Batch script
@REM ----------------------------------------------------------------------------
@echo off
setlocal

set MAVEN_PROJECTBASEDIR=%~dp0

set MVNW_REPOURL=https://repo.maven.apache.org/maven2
set WRAPPER_JAR="%MAVEN_PROJECTBASEDIR%.mvn\wrapper\maven-wrapper.jar"
set WRAPPER_LAUNCHER=org.apache.maven.wrapper.MavenWrapperMain
set DOWNLOAD_URL="%MVNW_REPOURL%/org/apache/maven/wrapper/maven-wrapper/3.2.0/maven-wrapper-3.2.0.jar"

if exist %WRAPPER_JAR% goto executeWrapper

echo Downloading Maven Wrapper...
powershell -Command "&{"^
	"$webclient = new-object System.Net.WebClient;"^
	"$webclient.DownloadFile('%DOWNLOAD_URL%', %WRAPPER_JAR%)"^
	"}"
if "%ERRORLEVEL%"=="0" goto executeWrapper

echo Failed to download Maven Wrapper
exit /b 1

:executeWrapper
java -jar %WRAPPER_JAR% %MAVEN_PROJECTBASEDIR%\.mvn\wrapper\maven-wrapper.properties %*
goto end

:end
