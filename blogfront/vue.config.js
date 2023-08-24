//第一步：在 vue.config.js 文件配置Api接口请求的服务端主机和端口，如下所示
const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  chainWebpack(config) {
    config.plugin('html').tap((args) => { 
      args[0].title = 'Seanのblog'
      return args
    })
  },
  devServer: {
    // host: 'localhost', // 主机
    port: 7070, // 端口
    hot: true, // 启用热更新
    https: false, // 是否开启 HTTPS 模式访问
    open: false, // 当项目启动后是否立即在浏览器打开
    proxy: {
      // 项目 v1 的服务端接口地址
      '/api': {
        target: 'http://localhost:9090/',
        changeOrigin: true,
        secure: false,
        ws: true,
        pathRewrite: {
          '^/api': '/'
        }
      },
 
      // 项目 v2 的服务端接口地址
      '/v2/api': {
        target: 'http://127.0.0.1:8092/',
        changeOrigin: true,
        secure: false,
        ws: true
      },
 
      // 项目 v3 的服务端接口地址
      '/v3/api': {
        target: 'http://127.0.0.1:8093/',
        changeOrigin: true,
        secure: false,
        ws: true
      },
 
      // // 默认服务端接口地址
      // '/': {
      //   target: 'http://127.0.0.1:8090/',
      //   changeOrigin: true,
      //   secure: false,
      //   ws: true
      // }
    }
  }
})

