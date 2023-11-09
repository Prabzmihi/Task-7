/**
 * 
 */
function doQuery()
{
//alert('doQuery...');	
	if((document.getElementById('tf01').value!='')&&(document.getElementById('tf02').value!='')&&(document.getElementById('tf03').value!='')&&(document.getElementById('tf04').value!='')&&(document.getElementById('tf05').value!='')&&(document.getElementById('tf06').value!='')&&(document.getElementById('tf07').value!='')&&(document.getElementById('tf09').value!=''))
	{
		var q_str = 'reqType=doQuery';

		q_str = q_str+'&para01='+document.getElementById('tf01').value;
		q_str = q_str+'&para02='+document.getElementById('tf02').value;
		q_str = q_str+'&para03='+document.getElementById('tf03').value;
		q_str = q_str+'&para04='+document.getElementById('tf04').value;
		q_str = q_str+'&para05='+document.getElementById('tf05').value;
		q_str = q_str+'&para06='+document.getElementById('tf06').value;
		q_str = q_str+'&para07='+document.getElementById('tf07').value;
		q_str = q_str+'&para07='+document.getElementById('tf08').value;
		q_str = q_str+'&para09='+document.getElementById('tf09').value;
		console.log(q_str);
		doAjax('Booking',q_str,'doQuery_back','post',0);
	}else
	{
		alert('Please, fill all the search fields...');
	}
}

function doQuery_back(result)
{
//alert('result:'+result);
 document.getElementById('results').innerText = result
}





/**
 * 
 */