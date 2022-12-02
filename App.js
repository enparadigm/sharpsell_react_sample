import React, { useState } from 'react';
import { Button, StyleSheet, Text, View, ScrollView, SafeAreaView, TextInput, Alert} from 'react-native';
import { NavigationContainer } from '@react-navigation/native';
import { createNativeStackNavigator } from '@react-navigation/native-stack';
import { StatusBar } from 'expo-status-bar';
import { NativeModules } from 'react-native';
import messaging from '@react-native-firebase/messaging';


const { SharpSellSDK } = NativeModules;

const Stack = createNativeStackNavigator();

const App = () => {
  return (
    <NavigationContainer>
      <Stack.Navigator
        screenOptions={{
          headerShown: false
        }}
        >
        <Stack.Screen
          name="LoginScreen"
          component={LoginScreen}
        />
        <Stack.Screen 
          name="HomeScreen" 
          component={HomeScreen} 
        />
      </Stack.Navigator>
    </NavigationContainer>
  );
};

export default App;

const LoginScreen = ({ navigation }) => {
  const [userUnqiueId1, setUserUnqiueIdOne] = useState('');
  const [userUnqiueId2, setUserUnqiueIdTwo] = useState('');
  const [userUnqiueId3, setUserUnqiueIdThree] = useState('');
  const [name, setName] = useState('');
  const [mobile, setMobile] = useState('');
  const [email, setEmail] = useState('');

  const createAlert = () =>
    Alert.alert(
      "Enter a company code",
      "",
      [
        { text: "OK", onPress: () => console.log("OK Pressed") }
      ]
    );

  
  const checkData = () => {
    if(userUnqiueId1 == ''){
      console.log('Fields are empty');
      createAlert();
    }else{
      navigation.navigate('HomeScreen', {
        "company_unique_id":userUnqiueId1,
        "user_unique_id":userUnqiueId2,
        "user_group_id":userUnqiueId3,
        "contactNumberPrimary": mobile,
        "firstName":name,
        "email":email,
      })
    }
  }

  return(
    <View style={styles.container}>
      <Text style={styles.titleText}>
        {"Sharpsell One SDK\n"}
      </Text>
      <TextInput 
        style={styles.input} 
        placeholder="User Unique ID" 
        onChangeText={(text) => setUserUnqiueIdOne(text)}
        value={userUnqiueId1}
      />
      <TextInput 
        style={styles.input} 
        keyboardType= "numeric"
        placeholder="User Unique ID" 
        onChangeText={(text) => setUserUnqiueIdTwo(text)}
        value={userUnqiueId2}
      />
      <TextInput 
        style={styles.input} 
        keyboardType= "numeric"
        placeholder="User Unique ID" 
        onChangeText={(text) => setUserUnqiueIdThree(text)}
        value={userUnqiueId3}
      />
      <TextInput 
        style={styles.input} 
        placeholder="Name" 
        onChangeText={(text) => setName(text)}
        value={name}
      />
      <TextInput 
        style={styles.input} 
        keyboardType= "numeric"
        placeholder="Mobile" 
        onChangeText={(text) => setMobile(text)}
        value={mobile}
      />
      <TextInput 
        style={styles.input} 
        placeholder="Email" 
        onChangeText={(text) => setEmail(text)}
        value={email}
      />
      <View style={{margin:10,width:350,height:100,borderRadius: 30}}>
        <Button
          title="Login"
          color="blue"
          accessibilityLabel="Tap to Decrypt Data"
          onPress={checkData}
        />  
      </View>
      <Text style={styles.titleTextTwo}>
        {"Release version - 2.7.0"}
      </Text>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },
  input:{
    borderRadius:10,
    borderWidth: 1,
    borderColor: "#777",
    padding: 8,
    margin:10,
    width: 350
  },
  button: {
    flexDirection: 'row', 
    height: 50,
    width: 350,
    backgroundColor: 'yellow',
    alignItems: 'center',
    justifyContent: 'center',
    marginTop: 50,
    elevation:3,
  },
  titleText: {
    fontSize: 25,
    fontWeight: "bold"
  },
  titleTextTwo: {
    fontSize: 20,
    fontWeight: "bold",
    textAlign: 'left'
  }
});

const HomeScreen = ({ navigation, route }) => {

  const getUserInfo = async () => {
    const fcmToken = await messaging().getToken();
    if (fcmToken) {
      let dataToSend = '{"company_unique_id":'+route.params.company_unique_id+',"user_unique_id":'+route.params.user_unique_id+',"user_group_id":'+route.params.user_group_id+',"contactNumberPrimary":'+route.params.contactNumberPrimary+'","firstName":'+route.params.firstName+',"email":'+route.params.email+',"fcmToken":"'+fcmToken+'"}';
      return dataToSend;
    }
  }
  
  const openHomePage = async () => {
    const str = await getUserInfo();
    SharpSellSDK.getHomeScreen(str)
  };
  
  const openLaunchPad = async () => {
    const str = await getUserInfo();
    SharpSellSDK.getLaunchpadScreen(str)
  };
  
  const openMc = async () => {
    const str = await getUserInfo();
    SharpSellSDK.getMarketingColletral(str)
  };
  
  const openProductPresentation = async () => {
    const str = await getUserInfo();
    SharpSellSDK.getPresentationScreen(str)
  };
  
  const openDigitalVc = async () => {
    const str = await getUserInfo();
    SharpSellSDK.getDigitalVc(str)
  };
  
  const openTimerChallenge = async () => {
    const str = await getUserInfo();
    SharpSellSDK.getTimerChallenge(str)
  };
  
  const openProductBundle = async () => {
    const str = await getUserInfo();
    SharpSellSDK.getProductBundle(str)
  };
  
  const openPotd = async () => {
    const str = await getUserInfo();
    SharpSellSDK.getPotd(str)
  };
  
  const openQuickLinks = async () => {
    const str = await getUserInfo();
    SharpSellSDK.getQuickLinks(str)
  };
  
  const openProfile = async () => {
    const str = await getUserInfo();
    SharpSellSDK.getProfile(str)
  };
  
  const logout = async () => {
    const str = await getUserInfo();
    SharpSellSDK.clearSharpSellSdkData(str)
  };

  return (
    <View style={styles.container}>
      <SafeAreaView style={styles.container}>
      <ScrollView contentContainerStyle={{ flexGrow: 1, justifyContent: 'center' }} style={styles.scrollView}>
  
      <Text>Hello There!</Text>
      <Text></Text>
      <Text>This is Demo Sharpsell SDK Project!</Text>
      <Text></Text>
      <Button title='Open Home Page' onPress={openHomePage}></Button>
      <Text></Text>
      <Button title='Open Launchpad' onPress={openLaunchPad}></Button>
      <Text></Text>
      <Button title='Marketing Collateral' onPress={openMc}></Button>
      <Text></Text>
      <Button title='Product Presentation' onPress={openProductPresentation}></Button>
      <Text></Text>
      <Button title='Poster Of The Day' onPress={openPotd}></Button>
      <Text></Text>
      <Button title='Digital visiting card' onPress={openDigitalVc}></Button>
      <Text></Text>
      <Button title='Timer challenge' onPress={openTimerChallenge}></Button>
      <Text></Text>
      <Button title='Product bundle' onPress={openProductBundle}></Button>
      <Text></Text>
      <Button title='Quick links' onPress={openQuickLinks}></Button>
      <Text></Text>
      <Button title='Profile' onPress={openProfile}></Button>
      <Text></Text>
      <Button title='Logout' onPress={logout}></Button>
      <StatusBar style="auto" />
      </ScrollView>
      </SafeAreaView>
    </View>
  );
}