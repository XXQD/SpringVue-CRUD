## 难点
    0、切换页面过度不自然
    1、递增的编号
    2、刷新样式
    3、点击修改内容可编辑状态 判断合法性 完成触发刷新
    4、删除提示(确定删除吗？) 完成触发刷新
    5、响应式布局页面缩小挤到一起
    6、单个搜索进行模糊匹配
    7、进行分页
    8、对输入的表格进行校验 对非法请求进行校验(比如我要String 传Integer)
    9、名称查询不能即使更新数据
    10、给搜索绑定回车键
## 解决方案 
    1、指定type='index'
    2、test-align='right'

## 遇到的问题
    1、后端返回响应的数据类型Result<>类
    2、前端Axios封装
    3、跨域解决同源策略(过滤器)
    4、父子组件通信传值 获取el-table-column的值使用插槽表达式
    5、postman测试putmapping sql忘记怎么写 raw传递json格式数据 后端接受对象使用@RequestBody
    6、在js中回调方法使用要加() 模板中不需要
    7、在net中封装put方法
    8、复用组件有props强制传值，可以设置默认值
    9、组件是复用的 因此使用插槽进行自定义 但是问题是最后处理组件的逻辑不一样
    10、前端调用后端接口卡的时间比较久 一个是ResultFul风格不太熟 一个是对响应头格式不太熟
    
