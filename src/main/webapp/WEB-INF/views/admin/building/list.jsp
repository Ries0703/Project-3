<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="margin-right" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:url var="buildingListURL" value="/admin/building-list"/>
<html>
<head>
    <title>
        Danh sách tòa nhà
    </title>

</head>
<body>
<div class="main-content">
    <div class="main-content-inner">
        <div class="breadcrumbs" id="breadcrumbs">
            <script type="text/javascript">
                try {
                    ace.settings.check("breadcrumbs", "fixed");
                } catch (e) {
                }
            </script>

            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                    <a href="#">Home</a>
                </li>

                <li>
                    <a href="#">UI &amp; Elements</a>
                </li>
                <li class="active">Content Sliders</li>
            </ul>
            <!-- /.breadcrumb -->

            <!-- /.nav-search -->
        </div>

        <div class="page-content">
            <div class="page-header">
                <h1
                        style="
                  font-weight: normal;
                  font-family: 'Times New Roman', Times, serif;
                "
                >
                    Danh sách tòa nhà
                </h1>
            </div>
            <!-- /.page-header -->

            <div class="row">
                <div class="col-xs-12">
                    <div
                            class="widget-box"
                            style="font-family: 'Times New Roman', Times, serif"
                    >
                        <div class="widget-header">
                            <h4
                                    class="widget-title"
                                    style="
                        font-weight: normal;
                        font-family: 'Times New Roman', Times, serif;
                      "
                            >
                                Tìm kiếm
                            </h4>

                            <span class="widget-toolbar">
                      <a href="#" data-action="reload">
                        <i class="ace-icon fa fa-refresh"></i>
                      </a>

                      <a href="#" data-action="collapse">
                        <i class="ace-icon fa fa-chevron-up"></i>
                      </a>
                    </span>
                        </div>

                        <div class="widget-body">
                            <div class="widget-main">
                                <form:form
                                        id="listForm"
                                        method="GET"
                                        action="/admin/building-list"
                                        modelAttribute="buildingSearchRequest"
                                >
                                    <div class="row">
                                        <div class="form-group">
                                            <div class="col-xs-12">
                                                <div class="col-sm-6">
                                                    <label for="name">Tên tòa nhà</label>
                                                    <form:input path="name" class="form-control"/>
                                                </div>
                                                <div class="col-sm-6">
                                                    <label for="name">Diện tích sàn</label>
                                                    <input
                                                            type="number"
                                                            class="form-control"
                                                            name="floorArea"
                                                            value="${buildingSearchRequest.floorArea}"
                                                    />
                                                </div>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <div class="col-xs-12">
                                                <div class="col-sm-2">
                                                    <label for="name">Quận</label>
                                                    <form:select path="district">
                                                        <form:option value="" label="---Chọn quận---"/>
                                                        <form:options items="${districtCodes}"/>
                                                    </form:select>
                                                </div>
                                                <div class="col-sm-5">
                                                    <label for="name">Phường</label>
                                                    <form:input path="ward" class="form-control"/>
                                                </div>
                                                <div class="col-sm-5">
                                                    <label for="name">Đường</label>
                                                    <form:input path="street" class="form-control"/>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <div class="col-xs-12">
                                                <div class="col-sm-4">
                                                    <label for="name">Số tầng hầm</label>
                                                    <input
                                                            type="number"
                                                            class="form-control"
                                                            name="numberOfBasement"
                                                            value="${buildingSearchRequest.numberOfBasement}"
                                                    />
                                                </div>
                                                <div class="col-sm-4">
                                                    <label for="name">Hướng</label>
                                                    <form:input path="direction" class="form-control"/>
                                                </div>
                                                <div class="col-sm-4">
                                                    <label for="name">Hạng</label>
                                                    <input
                                                            type="number"
                                                            class="form-control"
                                                            name="level"
                                                            value="${buildingSearchRequest.level}"
                                                    />
                                                </div>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <div class="col-xs-12">
                                                <div class="col-sm-3">
                                                    <label for="name">Diện tích từ</label>
                                                    <input
                                                            type="number"
                                                            class="form-control"
                                                            name="areaFrom"
                                                            value="${buildingSearchRequest.areaFrom}"
                                                    />
                                                </div>
                                                <div class="col-sm-3">
                                                    <label for="name">Diện tích đến</label>
                                                    <input
                                                            type="number"
                                                            class="form-control"
                                                            name="areaTo"
                                                            value="${buildingSearchRequest.areaTo}"
                                                    />
                                                </div>
                                                <div class="col-sm-3">
                                                    <label for="name">Giá thuê từ</label>
                                                    <input
                                                            type="number"
                                                            class="form-control"
                                                            name="rentPriceFrom"
                                                            value="${buildingSearchRequest.rentPriceFrom}"
                                                    />
                                                </div>
                                                <div class="col-sm-3">
                                                    <label for="name">Giá thuê đến</label>
                                                    <input
                                                            type="number"
                                                            class="form-control"
                                                            name="rentPriceTo"
                                                            value="${buildingSearchRequest.rentPriceTo}"
                                                    />
                                                </div>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <div class="col-xs-12">
                                                <div class="col-sm-5">
                                                    <label for="name">Tên quản lý</label>
                                                    <form:input path="managerName" class="form-control"/>
                                                </div>
                                                <div class="col-sm-5">
                                                    <label for="name">SĐT quản lý</label>
                                                    <input
                                                            type="number"
                                                            class="form-control"
                                                            name="managerPhone"
                                                            value="${buildingSearchRequest.managerPhone}"
                                                    />
                                                </div>
                                                <div class="col-sm-2">
                                                    <label for="name">Nhân viên phụ trách</label>
                                                    <form:select path="staffId">
                                                        <form:option value="" label="---Chọn NV---"/>
                                                        <form:options items="${staffs}"/>
                                                    </form:select>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <div class="col-xs-12">
                                                <div class="col-xs-6">
                                                    <form:checkboxes path="typeCode" items="${typeCodes}"/>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <div class="col-xs-12">
                                                <div class="col-xs-6">
                                                    <button class="btn btn-sm btn-primary" id="btnSearch">
                                                        <i
                                                                class="ace-icon glyphicon glyphicon-search"
                                                        ></i>
                                                        Tìm kiếm
                                                    </button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </form:form>
                            </div>
                        </div>
                    </div>
                    <div class="pull-right">
                        <a class="btn btn-primary" href="/admin/building-edit">
                            <svg
                                    xmlns="http://www.w3.org/2000/svg"
                                    width="16"
                                    height="16"
                                    fill="currentColor"
                                    class="bi bi-building-add"
                                    viewBox="0 0 16 16"
                            >
                                <path
                                        d="M12.5 16a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7m.5-5v1h1a.5.5 0 0 1 0 1h-1v1a.5.5 0 0 1-1 0v-1h-1a.5.5 0 0 1 0-1h1v-1a.5.5 0 0 1 1 0"
                                />
                                <path
                                        d="M2 1a1 1 0 0 1 1-1h10a1 1 0 0 1 1 1v6.5a.5.5 0 0 1-1 0V1H3v14h3v-2.5a.5.5 0 0 1 .5-.5H8v4H3a1 1 0 0 1-1-1z"
                                />
                                <path
                                        d="M4.5 2a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm-6 3a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm-6 3a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5z"
                                />
                            </svg>
                        </a>


                        <button
                                title="Xóa tòa nhà"
                                class="btn btn-danger"
                                id="btnDeleteBuilding"
                        >
                            <svg
                                    xmlns="http://www.w3.org/2000/svg"
                                    width="16"
                                    height="16"
                                    fill="currentColor"
                                    class="bi bi-building-fill-dash"
                                    viewBox="0 0 16 16"
                            >
                                <path
                                        d="M12.5 16a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7M11 12h3a.5.5 0 0 1 0 1h-3a.5.5 0 0 1 0-1"
                                />
                                <path
                                        d="M2 1a1 1 0 0 1 1-1h10a1 1 0 0 1 1 1v7.256A4.5 4.5 0 0 0 12.5 8a4.5 4.5 0 0 0-3.59 1.787A.5.5 0 0 0 9 9.5v-1a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .39-.187A4.5 4.5 0 0 0 8.027 12H6.5a.5.5 0 0 0-.5.5V16H3a1 1 0 0 1-1-1zm2 1.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5m3 0v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5m3.5-.5a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zM4 5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5M7.5 5a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm2.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5M4.5 8a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5z"
                                />
                            </svg>
                        </button>
                    </div>
                </div>
            </div>

            <div class="hr hr-18 dotted hr-double"></div>

            <div class="row">
                <div class="col-xs-12">
                    <table
                            id="buildingList"
                            class="table table-striped table-bordered table-hover"
                    >
                        <thead>
                        <tr>
                            <th class="center">
                                <label class="pos-rel">
                                    <input type="checkbox" class="ace" id="selectAllCheckboxBuilding" onclick="toggle(this)"/>
                                    <span class="lbl"></span>
                                </label>
                            </th>
                            <th>Tên tòa nhà</th>
                            <th>Địa chỉ</th>
                            <th>Số tầng hầm</th>
                            <th>Tên quản lý</th>
                            <th>SĐT quản lý</th>
                            <th>D.Tích sàn</th>
                            <th>D.Tích trống</th>
                            <th>D.Tích thuê</th>
                            <th>Giá Thuê</th>
                            <th>Phí dịch vụ</th>
                            <th>Phí MG</th>
                            <th>Thao tác</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="building" items="${buildingList}">
                            <tr>
                                <td class="center">
                                    <label class="pos-rel">
                                        <input type="checkbox" class="ace" name="building-checkbox" value="${building.id}"/>
                                        <span class="lbl"></span>
                                    </label>
                                </td>
                                <td>${building.name}</td>
                                <td>${building.address}</td>
                                <td>${building.numberOfBasement}</td>
                                <td>${building.managerName}</td>
                                <td>${building.managerPhone}</td>
                                <td>${building.floorArea}</td>
                                <td>${building.emptyArea}</td>
                                <td>${building.rentArea}</td>
                                <td>${building.rentPrice}</td>
                                <td>${building.serviceFee}</td>
                                <td>${building.brokerageFee}</td>
                                <td>
                                    <div>
                                        <button
                                                title="Giao tòa nhà"
                                                class="btn btn-sm btn-success"
                                                onclick="assignmentBuilding(${building.id})"
                                        >
                                            <svg
                                                    xmlns="http://www.w3.org/2000/svg"
                                                    width="16"
                                                    height="16"
                                                    fill="currentColor"
                                                    class="bi bi-list"
                                                    viewBox="0 0 16 16"
                                            >
                                                <path
                                                        fill-rule="evenodd"
                                                        d="M2.5 12a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5m0-4a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5m0-4a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5"
                                                />
                                            </svg>
                                        </button>
                                        <a
                                                href="/admin/building-edit-${building.id}"
                                                class="btn btn-sm btn-info"
                                                title="Sửa tòa nhà"
                                        >
                                            <i class="ace-icon fa fa-pencil-square-o"></i>
                                        </a>
                                        <button
                                                title="Xóa tòa nhà"
                                                class="btn btn-sm btn-danger"
                                                onclick="btnDeleteOneBuilding(${building.id})"
                                        >
                                            <i class="ace-icon glyphicon glyphicon-trash"></i>
                                        </button>
                                    </div>
                                </td>
                            </tr>
                        </c:forEach>

                        </tbody>
                    </table>
                </div>
            </div>
            <!-- /.row -->
        </div>
        <!-- /.page-content -->
    </div>
</div>
<!-- /.main-content -->

<div class="container">
    <!-- Modal -->
    <div class="modal fade" id="assignmentBuildingModal" role="dialog">
        <div class="modal-dialog">
            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title">Danh sách nhân viên</h4>
                </div>
                <div class="modal-body">
                    <!-- a table -->
                    <table class="table table-bordered" id="staffList">
                        <thead>
                        <tr>
                            <th class="center">
                                <label class="pos-rel"> Chọn </label>
                            </th>
                            <th class="center">Tên nhân viên</th>
                        </tr>
                        </thead>
                        <tbody>


                        </tbody>
                    </table>
                    <input type="hidden" id="buildingId" name="buildingId" value=""/>
                </div>
                <div class="modal-footer">
                    <button
                            type="button"
                            class="btn btn-default"
                            data-dismiss="modal"
                            id="btnAssignBuilding"
                    >
                        Giao tòa nhà
                    </button>

                    <button
                            type="button"
                            class="btn btn-default"
                            data-dismiss="modal"
                    >
                        Close
                    </button>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
    function toggle(source) {
        var checkboxes = document.getElementsByName('building-checkbox');
        for(var i=0, n=checkboxes.length;i<n;i++) {
            checkboxes[i].checked = source.checked;
        }
    }
    function assignmentBuilding(buildingId) {
        $("#assignmentBuildingModal").modal();
        $("#buildingId").val(buildingId);
        loadStaffs(buildingId);
    }

    function loadStaffs(buildingId) {
        $.ajax({
            type: "GET",
            url: "/api/buildings/" + buildingId + "/staffs",
            dataType: "json",
            success: response => {
                var row = '';
                $.each(response.data, (index, item) => {
                    row += `<tr>`
                    row += `<td class="center">`;
                    row += `<label class="pos-rel">`;
                    row += `<input type="checkbox" class="ace" id="checkbox_"` + item.staffId + ` value="` + item.staffId + `" ` + item.checked + `/>`;
                    row += `<span class="lbl"></span>`;
                    row += `</label>`;
                    row += `</td>`;
                    row += `<td class="center">` + item.fullName + `</td>`;
                    row += `</tr>`;
                });
                $('#staffList tbody').html(row);
            }
        });
    }

    $("#btnAssignBuilding").click(function (event) {
        event.preventDefault();
        var data = {};
        data["buildingId"] = $("#buildingId").val();
        data["staffIds"] = $("#staffList")
            .find("tbody input[type=checkbox]:checked")
            .map(function () {
                return $(this).val();
            })
            .get();

        $.ajax({
            type: "PUT",
            url: "/api/buildings/assign",
            data: JSON.stringify(data),
            contentType: "application/json",
            // dataType: "json" no return data so no need
            success: function (respond) {
                alert("building assigned");
            },
            failure: function () {
                alert("building not assigned");
            },
            error: function () {
                alert("an error occurred");
            },
        });
    });

    $("#btnDeleteBuilding").click(function (event) {
        event.preventDefault();
        var data = {};
        data["buildingIds"] = $("#buildingList")
            .find("tbody input[type=checkbox]:checked")
            .map(function () {
                return $(this).val();
            })
            .get();
        deleteBuilding(data);
    });

    function btnDeleteOneBuilding(id) {
        deleteBuilding({"buildingIds": [id]});
    }

    function deleteBuilding(data) {
        $.ajax({
            type: "DELETE",
            url: "/api/buildings" + (data["buildingIds"] === undefined || data["buildingIds"].length === 0 ? "" : "/" + data["buildingIds"]),
            data: JSON.stringify(data),
            contentType: "application/json",
            // dataType: "json" no return data so no need
            success: function (respond) {
                alert("building deleted");
                window.location.reload();
            },
            failure: function () {
                alert("building not deleted");
            },
            error: function (data) {
                data["buildingIds"] === undefined || data["buildingIds"].length === 0 ? alert("no buildings to delete") : alert("an error occurred");
            },
        });
    }

    $("#btnSearch").click(function (event) {
        event.preventDefault();
        $('#listForm').submit();
    });
</script>
<!-- <![endif]-->
</body>
</html>