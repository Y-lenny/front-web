var path = require('path')
var config = require('../config')
var utils = require('./utils')
var projectRoot = path.resolve(__dirname, '../')

module.exports = {
  entry: {
    index: './src/main.js',
    defaultTheme: './src/assets/metronic/layouts/layout/css/themes/default.min.css',
    darkblueTheme: './src/assets/metronic/layouts/layout/css/themes/darkblue.min.css',
    blueTheme: './src/assets/metronic/layouts/layout/css/themes/blue.min.css',
    greyTheme: './src/assets/metronic/layouts/layout/css/themes/grey.min.css',
    lightTheme: './src/assets/metronic/layouts/layout/css/themes/light.min.css',
    light2Theme: './src/assets/metronic/layouts/layout/css/themes/light2.min.css',
    componentsTheme: './src/assets/metronic/global/css/components.min.css',
    componentsRoundedTheme: './src/assets/metronic/global/css/components-rounded.min.css'
  },
  output: {
    path: config.build.assetsRoot,
    publicPath: config.build.assetsPublicPath,
    filename: '[name].js'
  },
  resolve: {
    extensions: ['', '.js', '.vue'],
    fallback: [path.join(__dirname, '../node_modules')],
    alias: {
      'src': path.resolve(__dirname, '../src'),
      'assets': path.resolve(__dirname, '../src/assets'),
      'components': path.resolve(__dirname, '../src/components')
    }
  },
  resolveLoader: {
    fallback: [path.join(__dirname, '../node_modules')]
  },
  module: {
    loaders: [
      {
        test: /\.vue$/,
        loader: 'vue'
      },
      {
        test: /\.js$/,
        loader: 'babel',
        include: projectRoot,
        exclude: /node_modules/
      },
      {
        test: /\.json$/,
        loader: 'json'
      },
      {
        test: /\.html$/,
        loader: 'vue-html'
      },
      {
        test: /\.(png|jpe?g|gif|svg)(\?.*)?$/,
        loader: 'url',
        query: {
          limit: 10000,
          name: utils.assetsPath('img/[name].[hash:7].[ext]')
        }
      },
      {
        test: /\.(woff2?|eot|ttf|otf)(\?.*)?$/,
        loader: 'url',
        query: {
          limit: 10000,
          name: utils.assetsPath('fonts/[name].[hash:7].[ext]')
        }
      }
    ]
  },
  vue: {
    loaders: utils.cssLoaders()
  }
}
