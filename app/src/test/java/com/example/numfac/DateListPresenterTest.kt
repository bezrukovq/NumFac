package com.example.numfac

import com.example.numfac.presenter.DateDetailPresenter
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
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.powermock.modules.junit4.PowerMockRunner


@RunWith(PowerMockRunner::class)
class DateListPresenterTest {

    @Mock
    lateinit var mockViewState: `DateListView$$State`

    lateinit var presenter: DateListPresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = Mockito.spy(DateListPresenter::class.java)
        presenter.setViewState(mockViewState)
    }

    @Test
    fun setDateListWork(){
        //Arrange
        var arrayList = ArrayList<Int>()
        //Act
        presenter.setDateList()
        //Assert
        verify(mockViewState).showDateList(arrayList)
    }
}