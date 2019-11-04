#!/bin/bash

#=============
#EDIT HERE
#=============

export serviceName=service-a
export dockerUser=mumcourses
export serviceVersion=latest

#=============
# NO MORE EDITS
#============

export serviceImage=$dockerUser/$serviceName:$serviceVersion

pushd ./templates && ./process.sh && popd
mv makefile.template makefile
echo "DONE!"