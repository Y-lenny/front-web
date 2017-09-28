/**
 * Created by aixiaoai on 16/7/11.
 */

export function initSelect2Directive(Vue) {
  Vue.directive('select2', {
    twoWay: true,
    priority: 2000,
    params: ['options'],
    bind: function () {
      var self = this
      $(this.el).select2().on('change', function () {
        self.set(this.value)
      })
    },
    update: function (value) {
      $(this.el).val(value).trigger('change')
    },
    unbind: function () {
      $(this.el).off().select2('destroy')
    }
  })
}
