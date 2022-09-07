# FFmpegKitSlim

Slim bindings for [FFmpegKit](https://github.com/tanersener/ffmpeg-kit) 


## Usage
```c#
FFmpegKitSlim.FFmpegKitHelper.Execute(string arguments)
FFmpegKitSlim.FFmpegKitHelper.Execute(string[] arguments)
```

## Build

1. Download ffmpeg-kit*.aar from https://github.com/tanersener/ffmpeg-kit/releases or build it (see `Build ffmpeg-kit using WSL.md`).

2. Rename file to `ffmpeg-kit.aar` and copy to 
android module `\FFmpegKitSlim\android\XamarinBindings\ffmpeg-kit`
and .net project `\FFmpegKitSlim\FFmpegKitSlim`

3. In Android Studio build ffmpegkitslim module - run 'XamarinBindings:ffmpegkitslim [assemble]' (Ctrl+F5)

4. Copy 
`ffmpegkitslim-release.aar` file
from 
`\FFmpegKitSlim\android\XamarinBindings\ffmpegkitslim\build\outputs\aar`
to
`\FFmpegKitSlim\FFmpegKitSlim`

5. In Visual Studio build FFmpegKitSlim project. 
By default nuget package is created only in Release mode and is added to local nuget repository. You can change it in `FFmpegKitSlim.csproj`
```xml
<PropertyGroup Condition=" '$(Configuration)'=='Release' ">
    <GeneratePackageOnBuild>true</GeneratePackageOnBuild>
</PropertyGroup>

<Target Name="NugetAdd" AfterTargets="Pack">
    <exec command="nuget add $(SolutionDir)nupkg\$(PackageId).$(PackageVersion).nupkg -source C:\Source\NugetRepo" />
</Target>
```
