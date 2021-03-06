package com.bingo.ybd.data.repository

import com.bingo.ybd.R
import com.bingo.ybd.constant.Constant
import com.bingo.ybd.data.model.*
import com.bingo.ybd.data.network.ApiService
import com.bingo.ybd.data.network.ServiceCreator
import com.bingo.ybd.data.storage.Preference

object Repository {

    private val apiService = ServiceCreator.create<ApiService>()


    suspend fun userLogin(phone: String, password: String): BaseResponse<UserInfo> {
        return apiService.login(phone, password)
    }


    suspend fun userRegiser(nick: String, phone: String, password: String): BaseResponse<Any> {
        return apiService.register(nick, phone, password)
    }

    suspend fun getTop5MedList(): BaseResponse<List<MedBrief>> = apiService.getTop5MedList()


    suspend fun getMedListByTypeId(
        typeId: Int, sortFlag: Int
    ): BaseResponse<List<MedBrief>> = apiService.getMedListByTypeId(typeId, sortFlag)


    suspend fun getMedDetail(medId: Int): BaseResponse<MedDetail> = apiService.getMedDetail(medId)

    suspend fun searchMed(
        keyword: String, sortFlag: Int
    ): BaseResponse<List<MedBrief>> = apiService.searchMed(keyword, sortFlag)

    suspend fun addMedToCurOrder(
        userId: Int, medId: Int
    ): BaseResponse<Any> = apiService.addMedToCurOrder(userId, medId)

    suspend fun getMedCartList(userId: Int): BaseResponse<List<MedInOrder>> =
        apiService.getMedCartList(userId)

    suspend fun subMedCount(
        medOrderId: Int, userId: Int
    ): BaseResponse<Any> = apiService.subMedCount(medOrderId, userId)

    suspend fun postOrder(
        userId: Int, userPhone: String,
        userName: String, userAddress: String, speed: Int, addressId: Int
    ): BaseResponse<Any> = apiService.postOrder(userId, userPhone, userName, userAddress, speed ,addressId)

    suspend fun getStartingOrderList(userId: Int): BaseResponse<List<Order>> =
        apiService.getStartingOrderList(userId)

    suspend fun getFinishedOrderList(userId: Int): BaseResponse<List<Order>> =
        apiService.getFinishedOrderList(userId)

    suspend fun getArticleList(): BaseResponse<List<Article>> = apiService.getArticleList()

    suspend fun getArticleDetail(articleId: Int): BaseResponse<Article> =
        apiService.getArticleDetail(articleId)

    suspend fun getArticleCommentList(articleId: Int): BaseResponse<List<Comment>> =
        apiService.getArticleCommentList(articleId)

    suspend fun addComment(
        articleId: Int, userId: Int, content: String, username: String
    ): BaseResponse<Any> = apiService.addComment(articleId, userId, content, username)

    fun saveUserInfo(userInfo: UserInfo) {

    }

    fun getUserPhoto(): Int {
        var photoList = listOf(
            R.mipmap.p0,
            R.mipmap.p1,
            R.mipmap.p2,
            R.mipmap.p3,
            R.mipmap.p4,
            R.mipmap.p5,
            R.mipmap.p6
        )
        var randomIndex = (0..6).random()
        return photoList[randomIndex]
    }

    suspend fun getSupportInfo(): BaseResponse<SupportInfo> = apiService.getSupportInfo()

    suspend fun getAddressInfoList(userId: String): BaseResponse<List<AddressInfo>> =
        apiService.getAddressInfoList(userId)

    suspend fun getLastUseAddressInfo(userId: String): BaseResponse<AddressInfo> =
        apiService.getLastUseAddressInfo(userId)

    suspend fun createAddressInfo(
        userId: Int,
        address: String,
        phone: String,
        userName: String,
        latitude: Double,
        longitude: Double
    ): BaseResponse<Any> = apiService.createAddressInfo(
        userId, address, phone, userName, latitude, longitude
    )

    suspend fun updateAddressInfo(
        id: Int,
        address: String,
        phone: String,
        userName: String,
        latitude: Double,
        longitude: Double
    ): BaseResponse<Any> = apiService.updateAddressInfo(
        id, address, phone, userName, latitude, longitude
    )
}