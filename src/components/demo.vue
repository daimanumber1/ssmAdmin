<template>
  <div class="head">
    <el-row>
      <el-col :span="24">
        <div class="grid-content bg-purple">
          <h3 class="topic">客户管理系统v2.0</h3>
        </div>
      </el-col>
    </el-row>
    <hr />
    <el-container>
      <el-aside class="aside" width="20%">1</el-aside>
      <el-main class="main">
        <!-- 主体部分的搜索框 -->
        <div class="slecetBox">
          <el-form :inline="true" :model="formInline" class="demo-form-inline">
            <el-form-item label="客户名称">
              <el-input v-model="formInline.user" placeholder="客户名称"></el-input>
            </el-form-item>
            <el-form-item label="客户来源" size="medium ">
              <el-select v-model="formInline.region" placeholder="客户来源" style="width: 120px;">
                <el-option label="区域一" value="shanghai"></el-option>
                <el-option label="区域二" value="beijing"></el-option>
              </el-select>
            </el-form-item>
            <el-form-item label="所属行业">
              <el-select v-model="formInline.region" placeholder="所属行业" style="width: 120px;">
                <el-option label="区域一" value="shanghai"></el-option>
                <el-option label="区域二" value="beijing"></el-option>
              </el-select>
            </el-form-item>
            <el-form-item label="客户级别">
              <el-select v-model="formInline.region" placeholder="客户级别" style="width: 120px;">
                <el-option label="区域一" value="shanghai"></el-option>
                <el-option label="区域二" value="beijing"></el-option>
              </el-select>
            </el-form-item>
            <el-form-item>
              <el-button type="primary" @click="onSubmit">查询</el-button>
            </el-form-item>
          </el-form>
        </div>
        <!--  -->
        <div class="userInfo">
          <el-table :data="tableData" border style="width: 100%">
            <el-table-column fixed prop="date" label="ID" width="150">
            </el-table-column>
            <el-table-column prop="name" label="姓名" width="120">
            </el-table-column>
            <el-table-column prop="province" label="客户来源" width="120">
            </el-table-column>
            <el-table-column prop="city" label="所属行业" width="120">
            </el-table-column>
            <el-table-column prop="address" label="客户级别" width="150">
            </el-table-column>
            <el-table-column prop="zip" label="固定电话" width="120">
            </el-table-column>
            <el-table-column prop="zip" label="固定电话" width="120">
            </el-table-column>
            <el-table-column fixed="right" label="操作" width="100">
              <template slot-scope="scope">
                <el-button @click="handleClick(scope.row)" type="text" size="medium ">修改</el-button>
                <el-button type="text" size="medium ">删除</el-button>
              </template>
            </el-table-column>
          </el-table>
        </div>
      </el-main>
    </el-container>
  </div>
</template>

<script>
  export default {
    name: "demo",
    data() {
      const item = {
        date: "2016-05-02",
        name: "王小虎",
        address: "上海市普陀区金沙江路 1518 弄"
      };
      return {
        tableData: Array(20).fill(item),
        formInline: {
          user: '',
          region: ''
        },
        tableData: [{
          date: '2016-05-03',
          name: '王小虎',
          province: '上海',
          city: '普陀区',
          address: '上海市普陀区金沙江路 1518 弄',
          zip: 200333
        }, {
          date: '2016-05-02',
          name: '王小虎',
          province: '上海',
          city: '普陀区',
          address: '上海市普陀区金沙江路 1518 弄',
          zip: 200333
        }, {
          date: '2016-05-04',
          name: '王小虎',
          province: '上海',
          city: '普陀区',
          address: '上海市普陀区金沙江路 1518 弄',
          zip: 200333
        }, {
          date: '2016-05-01',
          name: '王小虎',
          province: '上海',
          city: '普陀区',
          address: '上海市普陀区金沙江路 1518 弄',
          zip: 200333
        }]
      };
    },
    methods: {
      handleClick(row) {
        console.log(row);
      }
    },
  };

</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  .topic {
    line-height: 40px;
    font-weight: normal;
    color:#7d7b79
  }

  .el-col {
    border-radius: 4px;
  }

  .bg-purple {
    background: #f8f8f8;
    height: 40px;
  }

  aside {
    background: #f8f8f8;
  }

  .main {
    /* background: gray; */
  }

  .slecetBox {
    border: 1px solid #d3dce6;
    line-height: 100%;
    padding-left: 10px;
    border-radius: 10px;
  }

  .el-form-item {
    margin-top: 7px;
    margin-bottom: 7px;
  }

</style>
