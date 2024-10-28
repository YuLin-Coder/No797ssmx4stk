const base = {
    get() {
                return {
            url : "http://localhost:8080/ssmx4stk/",
            name: "ssmx4stk",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/ssmx4stk/front/index.html'
        };
            },
    getProjectName(){
        return {
            projectName: "微博系统网站"
        } 
    }
}
export default base
