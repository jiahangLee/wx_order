<html>
<#include "../common/header.ftl">
<body>
<div id="wrapper" class="toggled">
    <#include "../common/nav.ftl">
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <table class="table table-bordered table-condensed table-hover">
                        <thead>
                        <tr>
                            <th>
                                类目id
                            </th>
                            <th>
                                名称
                            </th>
                            <th>
                                type
                            </th>
                            <th>
                                创建时间
                            </th>
                            <th>
                                修改时间
                            </th>
                            <th>
                                操作
                            </th>
                        </tr>
                        </thead>
                        <tbody>
                <#list category as orderDTO>
                <tr>
                    <td>
                        ${orderDTO.categoryId}
                    </td>
                    <td>
                        ${orderDTO.categoryName}
                    </td>
                    <td>
                        ${orderDTO.categoryType}
                    </td>
                    <td>
                        ${orderDTO.createTime}
                    </td>
                    <td>
                        ${orderDTO.updateTime}
                    </td>
                    <td>
                        <a href="/sell/seller/category/index?categoryId=${orderDTO.categoryId}">修改</a>
                    </td>
                </tr>
                </#list>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>