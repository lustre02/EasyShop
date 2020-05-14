import request from '@/utils/request'

export function getTree(params) {
  return request({
    url: '/content/category/tree',
    method: 'get'
  })
}

export function getList(params) {
  return request({
    url: '/content/category/list',
    method: 'get'
  })
}
