# KotlinNativeWithUnity

Kotlin/NativeをUnityで扱えるのか？という検証プロジェクト

.

├── KotlinNativePlugin (Idea)

├── KotlinNativeWrapper (Visual Studio)

├── KotlinNativeWrapperForMac (Xcode)

└── UnityProject (Unity)

## 環境

Idea 2019.2.4

Xcode 11.2

Visual Studio 2019 16.3.7

## 確認方法

Ideaでビルドする

XcodeやVisual StudioはIdeaから吐き出されたファイルを参照してるので、そのままビルド

XcodeやVisual Studioで吐き出されたdllやbundleをUnityへコピー

Unityで動作確認