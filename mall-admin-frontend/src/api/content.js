import request from '@/utils/request'

export function getList(params) {
  return request({
    url: '/content/list',
    method: 'get'
  })
}

export function getListByCategoryId(categoryId) {
  return request({
    url: '/content/list/' + categoryId,
    method: 'get'
  })
}

export function getPageByCategoryId(categoryId, pageNum, pageSize) {
  return request({
    url: '/content/page/' + categoryId,
    method: 'get',
    params: {
      pageNum,
      pageSize
    }
  })
}

export function getTotal(categoryId) {
  return request({
    url: '/content/total/' + categoryId,
    method: 'get'
  })
}

export function add(data) {
  return request({
    url: '/content/insert',
    method: 'post',
    data
  })
}

export function del(id) {
  return request({
    url: '/content/delete/' + id,
    method: 'get'
  })
}
