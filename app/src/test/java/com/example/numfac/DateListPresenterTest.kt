package com.example.numfac

import com.example.numfac.model.NumFacModel
import com.example.numfac.presenter.DateListPresenter
import com.example.numfac.view.fragments.dateList.`DateListView$$State`
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.Spy
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class DateListPresenterTest {

    @Mock
    lateinit var mockViewState: `DateListView$$State`

    @Mock
    lateinit var mockmodel: NumFacModel

    @InjectMocks
    @Spy
    lateinit var presenter: DateListPresenter

    @Before
    fun setUp() = presenter.setViewState(mockViewState)

    @Test
    fun testSetDateListWork(){
        //Arrange
        //Act
        presenter.setDateList()
        //Assert
        verify(mockViewState).showDateList(mockmodel.getDateList())
    }

    @Test
    fun testExpendDateList() {
        //Arrange
        val expectedCount = 5
        //Act
        presenter.expendDateList(expectedCount)
        //Assert
        verify(mockViewState).expandDateList(mockmodel.expandDateList(expectedCount))
    }

    @Test
    fun testOpenDate() {
        //Arrange
        val expectedNum = 5
        //Act
        presenter.openDate(expectedNum)
        //Assert
        verify(mockViewState).openDate(expectedNum)
    }

}