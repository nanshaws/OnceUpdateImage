package main

import (
	"bufio"
	"fmt"
	"os"
	"path/filepath"
	"strings"
)

func main() {
	scanner := bufio.NewScanner(os.Stdin)
	fmt.Println("功能如下。")
	fmt.Println("1、单纯修改部分前缀，2、根据序列号修改名字")

	var selectOption int
	fmt.Scanln(&selectOption)

	switch selectOption {
	case 1:
		fmt.Println("请输入文件夹的名字:")
		scanner.Scan()
		directoryPath := scanner.Text()

		fmt.Println("请输入旧的前缀:")
		scanner.Scan()
		oldPrefix := scanner.Text()

		fmt.Println("请输入新的前缀:")
		scanner.Scan()
		newPrefix := scanner.Text()

		files, err := os.ReadDir(directoryPath)
		if err != nil {
			fmt.Println(directoryPath, "不是一个目录。")
			break
		}

		for _, file := range files {
			if strings.HasPrefix(file.Name(), oldPrefix) {
				newName := strings.Replace(file.Name(), oldPrefix, newPrefix, 1)
				oldPath := filepath.Join(directoryPath, file.Name())
				newPath := filepath.Join(directoryPath, newName)
				err := os.Rename(oldPath, newPath)
				if err != nil {
					fmt.Println("重命名失败:", file.Name())
				} else {
					fmt.Println("重命名:", file.Name(), "->", newName)
				}
			}
		}

	case 2:
		fmt.Println("请输入文件夹的名字:")
		scanner.Scan()
		directoryPath := scanner.Text()

		fmt.Println("请输入要修改的个数:")
		var count int
		fmt.Scanln(&count)

		s := make([]int, count)
		fmt.Println("请依次输入要改的序列号:")
		for i := 0; i < count; i++ {
			fmt.Scanln(&s[i])
		}

		fmt.Println("请输入新的名字:")
		scanner.Scan()
		baseNewName := scanner.Text()

		files, err := os.ReadDir(directoryPath)
		if err != nil {
			fmt.Println(directoryPath, "不是一个目录。")
			break
		}

		for _, file := range files {
			for _, num := range s {
				suffix := fmt.Sprintf("%02d.png", num)
				if strings.HasSuffix(file.Name(), suffix) {
					newName := fmt.Sprintf("%s_%d.png", baseNewName, num)
					oldPath := filepath.Join(directoryPath, file.Name())
					newPath := filepath.Join(directoryPath, newName)
					err := os.Rename(oldPath, newPath)
					if err != nil {
						fmt.Println("重命名失败:", file.Name())
					} else {
						fmt.Println("重命名:", file.Name(), "->", newName)
					}
				}
			}
		}
	}
}