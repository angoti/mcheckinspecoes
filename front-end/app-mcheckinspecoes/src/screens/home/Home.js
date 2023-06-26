import React from 'react';
import {View, Text, Image, StyleSheet} from 'react-native';
import Header from '../../components/Header/';

export default function Home() {
    return (
        <View style={styles.container}>
        <Header/>
        <Image source={require('../../../assets/btn-adicionar.png')} style={styles.button}/>
        <Text style={styles.title}>Criar Inspeção</Text>
        </View>
    );
}

const styles = StyleSheet.create({
    container: {
      flex: 1,
      justifyContent: 'center',
      alignItems: 'center',
    },
    title: {
        color: '#3CB371',
        fontWeight: 'bold',
        fontSize: 15,
        padding: 10
    },
    button: {
        margin: 15,
    }
  });