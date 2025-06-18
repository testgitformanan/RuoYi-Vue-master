import request from '@/utils/request'

// 查询无线感知工作参数配置列表
export function listGzcspz(query) {
  return request({
    url: '/wxgz/gzcspz/list',
    method: 'get',
    params: query
  })
}

// 查询无线感知工作参数配置详细
export function getGzcspz(id) {
  return request({
    url: '/wxgz/gzcspz/' + id,
    method: 'get'
  })
}

// 新增无线感知工作参数配置
export function addGzcspz(data) {
  return request({
    url: '/wxgz/gzcspz',
    method: 'post',
    data: data
  })
}

// 修改无线感知工作参数配置
export function updateGzcspz(data) {
  return request({
    url: '/wxgz/gzcspz',
    method: 'put',
    data: data
  })
}

// 删除无线感知工作参数配置
export function delGzcspz(id) {
  return request({
    url: '/wxgz/gzcspz/' + id,
    method: 'delete'
  })
}
