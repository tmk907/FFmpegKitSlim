# Build ffmpeg-kit using WSL

## Install Android SDK and NDK 
(https://dev.to/halimsamy/wsl-for-developers-installing-the-android-sdk-53n9)

### Installing OpenJDK and Gradle
```
sudo apt install openjdk-8-jdk-headless gradle
export JAVA_HOME=/usr/lib/jvm/java-8-openjdk-amd64
```

### Installing Android Command Line Tools
```
cd ~ # Make sure you are at home!
curl https://dl.google.com/android/repository/commandlinetools-linux-8512546_latest.zip -o /tmp/cmd-tools.zip
mkdir -p android/cmdline-tools
unzip -q -d android/cmdline-tools /tmp/cmd-tools.zip
mv android/cmdline-tools/cmdline-tools android/cmdline-tools/latest
rm /tmp/cmd-tools.zip # delete the zip file (optional)
```

### Setting up environment variables
```
export ANDROID_HOME=$HOME/android
export ANDROID_SDK_ROOT=${ANDROID_HOME}
export PATH=${ANDROID_HOME}/cmdline-tools/latest/bin:${ANDROID_HOME}/platform-tools:${ANDROID_HOME}/tools:${ANDROID_HOME}/tools/bin:${PATH}
```

### Accepting SDK licenses
```
yes | sdkmanager --licenses
```

### Installing SDK components
```
sdkmanager --update
sdkmanager "platforms;android-30" "build-tools;30.0.3"
```
### Installing NDK components
```
sdkmanager --update
sdkmanager "ndk;22.1.7171670"
export ANDROID_NDK_ROOT="/home/tomek/android/ndk/22.1.7171670"
```

### All exports
```
export JAVA_HOME=/usr/lib/jvm/java-8-openjdk-amd64
export ANDROID_HOME=$HOME/android
export ANDROID_SDK_ROOT=${ANDROID_HOME}
export ANDROID_NDK_ROOT="/home/tomek/android/ndk/22.1.7171670"
export PATH=${ANDROID_HOME}/cmdline-tools/latest/bin:${ANDROID_HOME}/platform-tools:${ANDROID_HOME}/tools:${ANDROID_HOME}/tools/bin:${PATH}
```

## Build ffmpeg-kit
https://github.com/tanersener/ffmpeg-kit/blob/main/android/README.md

### Install required packages
```
sudo apt install autoconf automake libtool pkg-config curl cmake gcc gperf texinfo yasm nasm bison autogen git wget autopoint meson ninja
```
https://github.com/tanersener/ffmpeg-kit/wiki/Android-Prerequisites

### Clone repository
```
cd ~ 
mkdir github
cd github
git clone https://github.com/tanersener/ffmpeg-kit.git
```
### Go to ffmpeg-kit directory
```
cd ~/github/ffmpeg-kit
```
### Build ffmpeg-kit.aar

Run `./android.sh` https://github.com/tanersener/ffmpeg-kit/wiki/android.sh