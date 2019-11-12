#!/bin/zsh 
echo "hello! this script helps you create a new folder with the correct template"
echo "please use generateservice.sh after this script to actually customize the new folder"
echo "this script requires zsh, to install it use sudo apt install zsh "
echo " or use your favorite package manager"" 
echo "-------------------------------------------------------------------------------------------"
echo "make sure you run this script in the directory you cloned from git (usually named K8s-demo)"
echo "the folder name, all small letters"
read foldername
echo "choose the number for the new service, is it ?"
echo " (1) stateless [no db] or "
echo " (2) statefull [with db] " 
echo "type the number only!"
read state
case $state in 
2)
	cp -r serviceTemplate ../$foldername	
	;;
1) 
	cp -r StatelessServiceA ../$foldername
	;;
*) 
	echo "incorrect option, try again later :P "
	;;
esac

echo "thank you for using this script, please check your new service template OUTSIDE the K8s-demo folder"
