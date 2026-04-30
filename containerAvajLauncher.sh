# /bin/bash

docker build . -t javaenv
docker run -it --name javaenv -v ./AvajLauncher:/home/AvajLauncher -w /home --rm javaenv /bin/bash