<template>
  <div class="head">
    <el-row class="header">
      <el-col :span="24">
        <div class="grid-content bg-purple">
          <h3 class="topic">客户管理系统v2.0</h3>
        </div>
      </el-col>
    </el-row>
    <el-container>
      <!-- 左侧导航条 -->
      <el-aside class="aside" width="15%">
      </el-aside>
      <!-- -------------------- -->
      <!-- ------------------- -->
      <el-main class="main">
        <!-- 主体部分的搜索框 -->
        <div class="slecetBox">
          <el-form :inline="true" :model="formInline" class="demo-form-inline">
            <el-form-item label="客户名称">
              <el-input v-model="formInline.user" placeholder="客户名称"></el-input>
            </el-form-item>
            <el-form-item label="客户来源" size="medium ">
              <el-select v-model="formInline.region" placeholder="客户来源" style="width: 120px;">
                <el-option v-for="clientSource in clientSourceList" :label="clientSource.dict_item_name" :value="clientSource.dict_id" :key="clientSource.id"></el-option>
              </el-select>
            </el-form-item>
            <el-form-item label="所属行业">
              <el-select v-model="formInline.region" placeholder="所属行业" style="width: 120px;">
                <el-option v-for="industry in industryList" :label="industry.dict_item_name" :value="industry.dict_id" :key="industry.id"></el-option>
              </el-select>
            </el-form-item>
            <el-form-item label="客户级别">
              <el-select v-model="formInline.region" placeholder="客户级别" style="width: 120px;">
                <el-option v-for="clientLevel in clientLevelList" :label="clientLevel.dict_item_name" :value="clientLevel.dict_id" :key="clientLevel.id"></el-option>
              </el-select>
            </el-form-item>
            <el-form-item>
              <el-button type="primary" @click="onSubmit">查询</el-button>
            </el-form-item>
          </el-form>
        </div>
        <!--用户信息 -->
        <div class="userInfo">
          <el-table :data="tableData" border style="width: 100%">
            <el-table-column fixed prop="cust_id" label="ID" width="100">
            </el-table-column>
            <el-table-column prop="cust_name" label="姓名" width="120">
            </el-table-column>
            <el-table-column prop="cust_source" label="客户来源" width="120">
            </el-table-column>
            <el-table-column prop="cust_industry" label="所属行业" width="120">
            </el-table-column>
            <el-table-column prop="cust_level" label="客户级别" width="150">
            </el-table-column>
            <el-table-column prop="cust_phone" label="固定电话" width="150">
            </el-table-column>
            <el-table-column prop="cust_mobile" label="手机" width="180">
            </el-table-column>
            <el-table-column fixed="right" label="操作" width="100">
              <template slot-scope="scope">
                <el-button @click="handleClick(scope.row)" type="text" size="medium ">修改</el-button>
                <el-button type="text" size="medium ">删除</el-button>
              </template>
            </el-table-column>
          </el-table>
        </div>
        <!-- 分页 -->
        <div>
          <el-pagination background layout="prev, pager, next" 
          :total="total" 
          :current-page="currPage"
          @current-change="handleCurrentChange" 
          @size-change="handleSizeChange"
          :page-sizes="[10, 20, 30, 40]"
           :page-size="pageSize"
          >
          </el-pagination>
        </div>
      </el-main>
    </el-container>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "demo",
  data() {
    const item = {
      date: "2016-05-02",
      name: "王小虎",
      address: "上海市普陀区金沙江路 1518 弄"
    };
    return {
      // tableData: Array(20).fill(item),
      clientLevelList: [],
      clientSourceList: [],
      industryList: [],
      formInline: {
        user: "",
        region: ""
      },
      tableData: [],
      currPage: 1,
      total: 0,
      pageSize: 10
    };
  },
  methods: {
    handleClick(row) {
      console.log(row);
    },
    onSubmit() {},
    handleCurrentChange(val) {
      console.log(val);
    },
    handleSizeChange(val) {
      console.log(val);
    },
    fun() {
      axios.get("http://localhost:8080/ssm/home").then(res => {
        console.log(res.data.aa);
        console.log(res.data.aa.total);
        this.clientSourceList = res.data.clientSourceList;
        this.industryList = res.data.industryList;
        this.clientLevelList = res.data.clientLevelList;
        this.tableData = res.data.page;
        // 分页
        this.total = res.data.aa.total;
      });
    }
  },
  mounted() {
    this.fun();
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.header {
  border-bottom: 1px solid #d3dce6;
}

.topic {
  line-height: 40px;
  font-weight: normal;
  color: #7d7b79;
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
  margin-bottom: 10px;
}

.el-form-item {
  margin-top: 7px;
  margin-bottom: 7px;
}
.el-pagination {
  padding-top: 15px;
  padding-left: 800px;
}
</style>
<style>
.el-pagination.is-background .btn-next,
.el-pagination.is-background .btn-prev,
.el-pagination.is-background .el-pager li {
  margin: 0 2px;
  min-width: 35px;
  height: 35px;
  line-height: 35px;
  font-size: 15px;
  font-weight: 500;
}
</style>
