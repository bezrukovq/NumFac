package com.example.numfac;

import com.example.numfac.entity.Date
import com.example.numfac.entity.DateDB
import com.example.numfac.model.NumFacApiService
import com.example.numfac.model.NumFacModel;
import com.example.numfac.presenter.DateDetailPresenter;
import com.example.numfac.view.fragments.DateView
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import com.example.numfac.view.fragments.`DateView$$State`
import org.mockito.*
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner
import kotlin.math.exp

@RunWith(MockitoJUnitRunner::class)
class DateDetailPresenterTest {

    @Mock
    lateinit var mockViewState: `DateView$$State`

    @Mock
    lateinit var mockmodel: NumFacModel

    @InjectMocks
    @Spy
    lateinit var presenter: DateDetailPresenter

    @Before
    fun setUp() = presenter.setViewState(mockViewState)

    @Test
    fun testSaveToFav(){
        //Arrange
        val mockDateDB = mock(DateDB::class.java)
        //Act
        presenter.saveToFav(mockDateDB)
        //Assert
        verify(mockmodel).addToFavList(mockDateDB)
    }

    @Test
    fun testDelFromFav() {
        //Arrange
        val mockDateDB = mock(DateDB::class.java)
        //Act
        presenter.deleteFromFav(mockDateDB)
        //Assert
        verify(mockmodel).deleteFromFavList(mockDateDB)
    }

    @Test
    fun testGetDateInfo() {
        //Arrange
        val expectedInt = 1
        val mockDate = mock(Date::class.java)
        doReturn(Single.just(mockDate)).`when`(mockmodel).getDateInfo(expectedInt)
        //Act
        presenter.getDateInfo(expectedInt)
        //Assert
        verify(mockmodel).getDateInfo(expectedInt)
        verify(mockViewState).showFact(mockDate)
        verify(mockViewState).showDate(mockDate)
        verify(mockViewState).showMonth(mockDate)
    }

    @Test
    fun testGetDateInfoWithError() {
        //Arrange
        val expectedInt = -10
        val expectedError = Throwable("message")

        doReturn(Single.error<Date>(expectedError)).`when`(mockmodel).getDateInfo(-10 )
        //Act
        presenter.getDateInfo(expectedInt)
        //Assert
        verify(mockmodel).getDateInfo(expectedInt)
        verify(mockViewState).showError(ArgumentMatchers.anyString())
    }

    @Test
    fun testGetDateInfoWithError2() {
        //Arrange
        val expectedInt: Int? = null
        //Act
        presenter.getDateInfo(expectedInt)
        //Assert
        verify(mockmodel, never()).getDateInfo(ArgumentMatchers.anyInt())
    }

    @Test
    fun testCheckCachedWhenCached(){
        //Arrange
        val cached = true
        doNothing().`when`(mockViewState).showCached(ArgumentMatchers.anyString())
        //Act
        presenter.checkCached(cached, "", 0)
        //Assert
        verify(presenter).showCached(ArgumentMatchers.anyString())
        assert(presenter.isLiked)
    }

    @Test
    fun testCheckCachedWhenNotCached(){
        //Arrange
        val cached = false
        doNothing().`when`(presenter).getDateInfo(ArgumentMatchers.anyInt())
        //Act
        presenter.checkCached(cached, "", 0)
        //Assert
        verify(presenter).getDateInfo(ArgumentMatchers.anyInt())
    }

    @Test
    fun likePressedWhenNotLiked(){
        //Arrange
        val dateDB = DateDB("")
        presenter.isLiked = false
        //Act
        presenter.likePressed(dateDB)
        //Assert
        verify(presenter).saveToFav(dateDB)
        verify(mockViewState).like()
        assert(presenter.isLiked)
    }
    
    @Test
    fun likePressedWhenLiked(){
        //Arrange
        val dateDB = DateDB("")
        presenter.isLiked = true
        //Act
        presenter.likePressed(dateDB)
        //Assert
        verify(presenter).deleteFromFav(dateDB)
        verify(mockViewState).unlike()
        assert(!presenter.isLiked)
    }
}
