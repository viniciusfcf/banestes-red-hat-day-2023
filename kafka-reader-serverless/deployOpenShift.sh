# podman machine init --cpus 5 --memory 8196
# podman machine set --rootful
# podman machine start
quarkus build --native --no-tests -Dquarkus.kubernetes.deploy=true -Dquarkus.native.container-build=true -Dquarkus.native.native-image-xmx=5g