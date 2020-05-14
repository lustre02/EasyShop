import request from '@/utils/request'

export function getTree() {
  return request({
    url: '/item/cat/tree',
    method: 'get'
  })
}
