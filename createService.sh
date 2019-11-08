#!/bin/bash  
echo "make sure you run this script in the directory you cloned from git (usually named K8s-demo)"
echo "tell me the folder name, all small letters"
read foldername
echo "the new service is ? stateless [no db] (1) or statefull [with db] (2)" 
read state
case $state in 
2)
	cp -r serviceTemplate ../$foldername	
	;;
1) 
	cp -r StatelessServiceA ../$foldername
	;;
*) 
	echo "in correct option, try again later :) "
	;;
esac

echo "thank you for using this script, please check your new service template outside the K8s-demo folder"
