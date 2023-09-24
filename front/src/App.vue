<template>
  <div id="app">
    <router-view/>
  </div>
</template>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: white;
}

nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}

nav a.router-link-exact-active {
  color: #42b983;
}
.el-calendar__title{
    color: white !important;
}
.el-button--mini{
    color: white !important;
}
.el-button--mini:hover{
    color: grey !important;
}
.el-button{
    color: white !important;
    background: rgba(24, 24, 24, 0.6) !important;
    border: 0 solid #000000 !important;
}
.el-button:hover{
    color: grey !important;
    background: rgba(24, 24, 24, 0.6) !important;
}
.el-calendar-table tr:first-child td{
    border-top: 1px solid grey !important;
}
.el-calendar-table tr td:first-child{
    border-left: 1px solid grey !important;
}
.el-calendar-table td{
    border-right: 1px solid grey !important;
    border-bottom: 1px solid grey !important;
}
.el-calendar-table thead th{
    color: white !important;
}
.el-calendar-table td.is-selected{
    background-color: rgba(77, 77, 77, 0.6) !important;
}
.el-calendar-day:hover{
    background-color: rgba(77, 77, 77, 0.6) !important;
}
.el-card{
    background-color: rgba(24, 24, 24, 0.6) !important;
    border-radius: 20px !important;
    border: 0 solid #090A0F !important;
    box-shadow: 0 5px 12px rgba(0,0,0,0.5) !important;
    margin: 1vh 0 0 4vh;
}
</style>
