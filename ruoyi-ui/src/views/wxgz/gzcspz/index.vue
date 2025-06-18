<template>
  <div class="app-container">
    <el-form v-show="showSearch" ref="queryRef" :inline="true" :model="queryParams" label-width="68px">
      <el-form-item label="参数1" prop="cs1">
        <el-input
          v-model="queryParams.cs1"
          clearable
          placeholder="请输入参数1"
          @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item label="参数2" prop="cs2">
        <el-input
          v-model="queryParams.cs2"
          clearable
          placeholder="请输入参数2"
          @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item label="参数3" prop="cs3">
        <el-input
          v-model="queryParams.cs3"
          clearable
          placeholder="请输入参数3"
          @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item label="参数4" prop="cs4">
        <el-input
          v-model="queryParams.cs4"
          clearable
          placeholder="请输入参数4"
          @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button icon="Search" type="primary" @click="handleQuery">搜索</el-button>
        <el-button icon="Refresh" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          v-hasPermi="['wxgz:gzcspz:add']"
          icon="Plus"
          plain
          type="primary"
          @click="handleAdd"
        >新增
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          v-hasPermi="['wxgz:gzcspz:edit']"
          :disabled="single"
          icon="Edit"
          plain
          type="success"
          @click="handleUpdate"
        >修改
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          v-hasPermi="['wxgz:gzcspz:remove']"
          :disabled="multiple"
          icon="Delete"
          plain
          type="danger"
          @click="handleDelete"
        >删除
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          v-hasPermi="['wxgz:gzcspz:export']"
          icon="Download"
          plain
          type="warning"
          @click="handleExport"
        >导出
        </el-button>
      </el-col>
      <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="gzcspzList" @selection-change="handleSelectionChange">
      <el-table-column align="center" type="selection" width="55"/>
      <el-table-column align="center" label="主键" prop="id"/>
      <el-table-column align="center" label="参数1" prop="cs1"/>
      <el-table-column align="center" label="参数2" prop="cs2"/>
      <el-table-column align="center" label="参数3" prop="cs3"/>
      <el-table-column align="center" label="参数4" prop="cs4"/>
      <el-table-column align="center" class-name="small-padding fixed-width" label="操作">
        <template #default="scope">
          <el-button v-hasPermi="['wxgz:gzcspz:edit']" icon="Edit" link type="primary" @click="handleUpdate(scope.row)">
            修改
          </el-button>
          <el-button v-hasPermi="['wxgz:gzcspz:remove']" icon="Delete" link type="primary"
                     @click="handleDelete(scope.row)">删除
          </el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      v-model:limit="queryParams.pageSize"
      v-model:page="queryParams.pageNum"
      :total="total"
      @pagination="getList"
    />

    <!-- 添加或修改无线感知工作参数配置对话框 -->
    <el-dialog v-model="open" :title="title" append-to-body width="500px">
      <el-form ref="gzcspzRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="参数1" prop="cs1">
          <el-input v-model="form.cs1" placeholder="请输入参数1"/>
        </el-form-item>
        <el-form-item label="参数2" prop="cs2">
          <el-input v-model="form.cs2" placeholder="请输入参数2"/>
        </el-form-item>
        <el-form-item label="参数3" prop="cs3">
          <el-input v-model="form.cs3" placeholder="请输入参数3"/>
        </el-form-item>
        <el-form-item label="参数4" prop="cs4">
          <el-input v-model="form.cs4" placeholder="请输入参数4"/>
        </el-form-item>
      </el-form>
      <template #footer>
        <div class="dialog-footer">
          <el-button type="primary" @click="submitForm">确 定</el-button>
          <el-button @click="cancel">取 消</el-button>
        </div>
      </template>
    </el-dialog>
  </div>
</template>

<script name="Gzcspz" setup>
import {addGzcspz, delGzcspz, getGzcspz, listGzcspz, updateGzcspz} from "@/api/wxgz/gzcspz"

const {proxy} = getCurrentInstance()

const gzcspzList = ref([])
const open = ref(false)
const loading = ref(true)
const showSearch = ref(true)
const ids = ref([])
const single = ref(true)
const multiple = ref(true)
const total = ref(0)
const title = ref("")

const data = reactive({
  form: {},
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    cs1: null,
    cs2: null,
    cs3: null,
    cs4: null,
  },
  rules: {
    createTime: [
      {required: true, message: "创建时间不能为空", trigger: "blur"}
    ],
    updateTime: [
      {required: true, message: "修改时间不能为空", trigger: "blur"}
    ]
  }
})

const {queryParams, form, rules} = toRefs(data)

/** 查询无线感知工作参数配置列表 */
function getList() {
  loading.value = true
  listGzcspz(queryParams.value).then(response => {
    gzcspzList.value = response.rows
    total.value = response.total
    loading.value = false
  })
}

// 取消按钮
function cancel() {
  open.value = false
  reset()
}

// 表单重置
function reset() {
  form.value = {
    id: null,
    cs1: null,
    cs2: null,
    cs3: null,
    cs4: null,
    createTime: null,
    updateTime: null
  }
  proxy.resetForm("gzcspzRef")
}

/** 搜索按钮操作 */
function handleQuery() {
  queryParams.value.pageNum = 1
  getList()
}

/** 重置按钮操作 */
function resetQuery() {
  proxy.resetForm("queryRef")
  handleQuery()
}

// 多选框选中数据
function handleSelectionChange(selection) {
  ids.value = selection.map(item => item.id)
  single.value = selection.length != 1
  multiple.value = !selection.length
}

/** 新增按钮操作 */
function handleAdd() {
  reset()
  open.value = true
  title.value = "添加无线感知工作参数配置"
}

/** 修改按钮操作 */
function handleUpdate(row) {
  reset()
  const _id = row.id || ids.value
  getGzcspz(_id).then(response => {
    form.value = response.data
    open.value = true
    title.value = "修改无线感知工作参数配置"
  })
}

/** 提交按钮 */
function submitForm() {
  proxy.$refs["gzcspzRef"].validate(valid => {
    if (valid) {
      if (form.value.id != null) {
        updateGzcspz(form.value).then(response => {
          proxy.$modal.msgSuccess("修改成功")
          open.value = false
          getList()
        })
      } else {
        addGzcspz(form.value).then(response => {
          proxy.$modal.msgSuccess("新增成功")
          open.value = false
          getList()
        })
      }
    }
  })
}

/** 删除按钮操作 */
function handleDelete(row) {
  const _ids = row.id || ids.value
  proxy.$modal.confirm('是否确认删除无线感知工作参数配置编号为"' + _ids + '"的数据项？').then(function () {
    return delGzcspz(_ids)
  }).then(() => {
    getList()
    proxy.$modal.msgSuccess("删除成功")
  }).catch(() => {
  })
}

/** 导出按钮操作 */
function handleExport() {
  proxy.download('wxgz/gzcspz/export', {
    ...queryParams.value
  }, `gzcspz_${new Date().getTime()}.xlsx`)
}

getList()
</script>
