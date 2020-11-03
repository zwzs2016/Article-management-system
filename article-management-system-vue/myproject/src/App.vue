<template>
  <div id="app">
    <router-view />
  </div>
</template>

<script>

export default {
  name: 'App',
  components: {
  }
}
</script>

<style lang="scss">
*{
  margin: 0;
  padding: 0;
}
body,html{
	width:100%;
	height:100%;
}
div{
  &::-webkit-scrollbar { width: 0 !important }
    -ms-overflow-style: none;
}
#app{
	width:100%;
	height:100%;
}
ul,li{
  list-style: none;
}
</style>
