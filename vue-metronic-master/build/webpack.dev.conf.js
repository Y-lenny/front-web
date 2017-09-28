var config = require('../config')
var webpack = require('webpack')
var merge = require('webpack-merge')
var utils = require('./utils')
var baseWebpackConfig = require('./webpack.base.conf')
var HtmlWebpackPlugin = require('html-webpack-plugin')
var ExtractTextPlugin = require('extract-text-webpack-plugin')

// add hot-reload related code to entry chunks
Object.keys(baseWebpackConfig.entry).forEach(function (name) {
  baseWebpackConfig.entry[name] = ['./build/dev-client'].concat(baseWebpackConfig.entry[name])
})

module.exports = merge(baseWebpackConfig, {
  module: {
    loaders: utils.styleLoaders({
      extract: true
    })
  },
  // eval-source-map is faster for development
  devtool: '#eval-source-map',
  plugins: [
    new webpack.DefinePlugin({
      'process.env': config.dev.env
    }),
    // https://github.com/glenjamin/webpack-hot-middleware#installation--usage
    new webpack.optimize.OccurenceOrderPlugin(),
    new webpack.HotModuleReplacementPlugin(),
    new webpack.NoErrorsPlugin(),
    // https://github.com/ampedandwired/html-webpack-plugin
    new HtmlWebpackPlugin({
      filename: 'index.html',
      //设置模板
      template: 'src/index.html',
      favicon: 'src/assets/favicon.ico',
      excludeChunks: ['defaultTheme', 'darkblueTheme', 'blueTheme', 'greyTheme', 'lightTheme', 'light2Theme', 'componentsTheme', 'componentsRoundedTheme'],
      inject: true
    }),
    new webpack.ProvidePlugin({
      $: "jquery",
      jQuery: "jquery",
      "window.jQuery": "jquery",
      App: "!exports?App!assets/metronic/global/scripts/app.min",
      Layout: "!exports?Layout!assets/metronic/layouts/layout/scripts/layout.min",
      toastr: "assets/metronic/global/plugins/bootstrap-toastr/toastr.min"
    }),
    new ExtractTextPlugin(utils.assetsPath('/css/[name].css'))
  ]
})
