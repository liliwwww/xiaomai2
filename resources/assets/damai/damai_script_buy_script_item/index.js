//------ts start------
//UEsDBBQAAAgIAJtQKVWbDouwQAIAAAQFAAAIAAAAaW5kZXguanOtVE1v00AQvedXDD5UTooSxLEGCbU9cOECvUU9bONxYursRt51S5XmgIpAoEbpoShV+BBFVVWkQCMOCEVp+TONk5z4C6ztTbIpLQiJy3pn5r23s89jL7FyhVGkwqymALggAhegWrspA0YfldjmAjgBLQiXUTDTEIEAcrnwtBG2D8OTw/Ddj/DgfHDUHe2cXfRa/Tfvh50dCVIKD5HYW9dIxOT+UX2wfxI2v02YABvEB4qby0QQuAui5PKsLfdLjG6gL8y0FaPiPEcRwUwFj0vq6PuujX9vftTaGzYb1zUf8Csl/k+Dy8iFz/7sTuf58Pjp6MWrcP980HqmNyjXXCYToTMQvu6E9S/hh16/1xietcP6xyR/z0cR+JRDla09xoKoxemcXLV2/+GC1qTImYcrpLiC5YoEGEZScR0wJ+C8wYmHD5iNnkRyY3UsDlBglAuYKevH/Ma0UoroMB9MDwW41MYnknPLUts7s3JZD2lRlFR1fn56dtI/eliWQy8VZmj5GL5qTbDRWWKrghKoKHkjig0NE936Rty8yxc9QtfNCJGGuTlFlQbdNvQO4JJ/E2kbeUGXBljzkaxPE7WU/kxW9aKys5palNCTWRijrSum6OC0v3d88b07+NTtf24O2nL/9WdvN3z7UmbkdEmAXlIzViE+KUNVzrJLizX5C/EvD98ik70QOp0+5ZM+eZI2dijyU4aRbzTwPNjejn1kDqisEci35LgUbSMqjrOaxequwg/Q0pxSaYd4HJUBNflF/gJQSwECFAMUAAAICACbUClVmw6LsEACAAAEBQAACAAAAAAAAAAAAAAApIEAAAAAaW5kZXguanNQSwUGAAAAAAEAAQA2AAAAZgIAAAAA
//------ts end------

Component({state:{},onShow:function(){},onReady:function(){var t=this.dataConvert();this.setData(t)},onHide:function(){},onReuse:function(){var t=this.dataConvert();this.setData(t)},onDestroy:function(){},dataConvert:function(){var t=this.data,a="";if(this.data.saleModelTags)for(var n=this.data.saleModelTags,e=0;e<n.length;e++){var o=n[e],i=o.type;if(!this.isBlank(i)&&"2"==i){a=o.desc;break}}return t.soleTagTemp=a,t},isBlank:function(t){return null==t||void 0===t||""==t}});