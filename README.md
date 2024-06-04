# OnceUpdateImage
一键修改图片后缀名，结合magick，可以为gdx开发者简化繁杂的工作    One-click modification of image suffix, combined with MagicK, can simplify the complicated work for GDX developers 

magick用法

官网：[ImageMagick – Mastering Digital Image Alchemy](https://imagemagick.org/)

安装后，直接运行cmd命令

```
magick convert player.png -crop 48x48 player/frame_%02d.png
```

这条命令是将player.png文件直接以48x48分到player文件夹里面，以frame_为前缀，后面序号0-max.png

![image-20240605071730961](./img/image-20240605071730961.png)

![image-20240605071802932](./img/image-20240605071802932.png)

这个时候使用此应用

该项目代码已经打包成exe文件了。

![image-20240605072655776](./img/image-20240605072655776.png)

![image-20240605071506699](./img/image-20240605071506699.png)

![image-20240605071641210](./img/image-20240605071641210.png)

