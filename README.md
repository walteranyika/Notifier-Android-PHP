# Firebase Android Notification with PHP backend

This is a simple android application to demo push notification with Firebase and PHP as a Backend. The PHP code to is shown below.
You need to add your firebase server API Key and the registration Ids for the devices.

You also need to generate **google-services.json** for your project from [Firebase](https://firebase.google.com/docs/android/setup)

###### PHP Backend code
```
<?php
#API access key from Google API's Console
define( 'API_ACCESS_KEY', 'REPLACE WITH  YOUR SERVER API KEY HERE' );
#You could modify this to read the ids from a database
$registrationIds ='REPLACE WITH THE RECIPIENT'S REG ID/REG TOKEN';
$msg = array('body'=> 'Body  Of Notification','title'=> 'Title Of Notification');
$fields = array('to'=> $registrationIds,'notification'	=> $msg);
$headers = array('Authorization: key=' . API_ACCESS_KEY,'Content-Type: application/json');
#Send Reponse To FireBase Server
$ch = curl_init();
curl_setopt( $ch,CURLOPT_URL, 'https://fcm.googleapis.com/fcm/send' );
curl_setopt( $ch,CURLOPT_POST, true );
curl_setopt( $ch,CURLOPT_HTTPHEADER, $headers );
curl_setopt( $ch,CURLOPT_RETURNTRANSFER, true );
curl_setopt( $ch,CURLOPT_SSL_VERIFYPEER, false );
curl_setopt( $ch,CURLOPT_POSTFIELDS, json_encode( $fields ) );
$result = curl_exec($ch );
curl_close( $ch );
#Echo Result Of FireBase Server
echo $result;
```



