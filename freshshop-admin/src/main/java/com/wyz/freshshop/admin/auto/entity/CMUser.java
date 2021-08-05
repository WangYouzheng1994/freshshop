package com.wyz.freshshop.admin.auto.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 后台用户表
 * </p>
 *
 * @author WangYouzheng
 * @since 2021-06-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CMUser implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "pid", type = IdType.AUTO)
    private Integer pid;

    private String userId;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 公司名称
     */
    private String companyName;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 用户密码
     */
    private String password;

    /**
     * des3
     */
    private String des3;

    /**
     * 手机号码
     */
    private String mobileNumber;

    /**
     * 分机号
     */
    private String extensionNumber;

    /**
     * 其他固话 逗号分割
     */
    private String otherExtensionNumber;

    /**
     * 固话
     */
    private String guhuaNumber;

    /**
     * 分机号
     */
    private String fenjiNumber;

    /**
     * 住址
     */
    private String address;

    /**
     * 电子邮箱
     */
    private String emailAddress;

    /**
     * 1：邀约员   2：外访员 3 ：内审员
     */
    private String userFlag;

    /**
     * 备注
     */
    private String notes;

    /**
     * 员工编号
     */
    private String userNo;

    /**
     * 角色缩写
     */
    private String roleAd;

    /**
     * 职位
     */
    private String position;

    /**
     * HR系统人员编号
     */
    private String hrNo;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 分公司名称缩写
     */
    private String departmentAb;

    /**
     * 性别（1：男，0：女）
     */
    private String sex;

    /**
     * 入职日期
     */
    private String joinDate;

    /**
     * 离职日期
     */
    private Integer leaveDate;

    /**
     * 出生日期
     */
    private String birthday;

    /**
     * 身份证号
     */
    private String idNo;

    /**
     * 用户客户类型（0：全部，1：用户客户类别关联表）
     */
    private String userType;

    /**
     * 头像
     */
    private String userIcon;

    /**
     * 银行卡号
     */
    private String cardNo;

    private Integer userSortKey;

    /**
     * 同意用户协议(0：同意，1：不同意)
     */
    private String isAgreeAgreement;

    /**
     * 上一次登陸時間
     */
    private String lastLoginTime;

    /**
     * 用户输入错误密码次数
     */
    private Integer pwdErrorTime;

    /**
     * 错误时间（第一次）
     */
    private String pwdErrorDate;

    /**
     * 删除标识 0:正常 1:禁用 2:锁定 3:暂停使用
     */
    private String delFlag;

    /**
     * 保留上一次的 删除标识 下次恢复使用0:正常 1:禁用 2:锁定 3:暂停使用
     */
    private String lastDelFlag;

    /**
     * 初期新建部门编号
     */
    private String createGroupCd;

    /**
     * 初期新建者
     */
    private String createUserCd;

    /**
     * 初期新建日
     */
    private String createDate;

    /**
     * 最终更新部门编号
     */
    private String updateGroupCd;

    /**
     * 最终更新者
     */
    private String updateUserCd;

    /**
     * 最终更新日
     */
    private String updateDate;

    /**
     * 是否进行性格测试 0 未测试 1已测试
     */
    private Boolean isQuestion;

    /**
     * 易米账号
     */
    private String yimiNumber;

    /**
     * 华为坐席号
     */
    private String huaweiNumber;

    /**
     * 华为坐席密码
     */
    private String huaweiPassword;

    /**
     * 赛普分公司ip地址
     */
    private String departmentIpSaipu;

    /**
     * 赛普所属分公司cd
     */
    private String departmentIpSaipuCd;

    /**
     * 赛普所属分公司name
     */
    private String departmentIpSaipuName;

    /**
     * 显示姓名
     */
    private String showName;

    /**
     * 三汇坐席号
     */
    private String sanhuiNumber;

    /**
     * 联信坐席号
     */
    private String lianxinNumber;

    /**
     * app手势密码
     */
    private String gesturePassword;

    /**
     * 上次密码设置时间
     */
    private Integer lastUpdatePasswordTime;

    /**
     * 新生代帐号
     */
    private String newGenerationAccount;

    /**
     * 信修员专用入职时间
     */
    private LocalDateTime seekerJoinDate;

    /**
     * 新生代坐席号
     */
    private String xinshengdaiNumber;

    /**
     * 是否是兼岗账号 0不是  1是
     */
    private Boolean isJiangang;


}
