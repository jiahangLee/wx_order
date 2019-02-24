<html>
<#include "../common/header.ftl">
<body>
<div id="wrapper" class="toggled">
    <#include "../common/nav.ftl">
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <form role="form" method="post" action="/sell/seller/category/save">
                        <div class="form-group">
                            <label for="exampleInputEmail1">名称</label>
                            <input name="categoryName" type="text"  id="exampleInputEmail1" class="form-control" value="${(productCategory.categoryName)!''}" />
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1">Type</label>
                            <input name="categoryType" type="text" class="form-control" id="exampleInputPassword1" value="${(productCategory.categoryType)!''}"/>
                        </div>
                        <input hidden type="text" name="categoryId" value="${(productCategory.categoryId)!''}">
                        <button type="submit" class="btn btn-default">提交</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>