package com.example.android.eduhub;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import static android.app.Activity.RESULT_OK;
import static com.example.android.eduhub.EditProfilePopUp.editProfile;
import static com.example.android.eduhub.MainActivity.loginID;

public class ProfileFragment extends android.support.v4.app.Fragment {

    UserDbHelper userDb;
//    public static int RESULT_LOAD_IMAGE = 1;
    final int REQUEST_CODE_GALLERY = 999;
    UserProfilePicDbHelper userProfilePicDb;


    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);

    }



    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle("Profile");

        TextView textViewMutableNameProfile = getView().findViewById(R.id.textViewMutableNameProfile);
        TextView textViewMutableUserNameProfile = getView().findViewById(R.id.textViewMutableUserNameProfile);
        TextView textViewMutableEmailProfile = getView().findViewById(R.id.textViewMutableEmailProfile);
        final ImageView imageViewProfilePic = getView().findViewById(R.id.imageViewProfilePic);
        Button btnEditProfile = getView().findViewById(R.id.btnEditProfile);
        userDb = new UserDbHelper(getActivity());
        userProfilePicDb = new UserProfilePicDbHelper(getActivity());

        User user = userDb.getUser(loginID);
        textViewMutableNameProfile.setText(user.getName());
        textViewMutableUserNameProfile.setText(user.getUserName());
        textViewMutableEmailProfile.setText(user.getEmail());

//        imageViewProfilePic.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//                startActivityForResult(galleryIntent, RESULT_LOAD_IMAGE);
//            }
//        });

        btnEditProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent editProfileIntent = new Intent(getActivity(), EditProfilePopUp.class);
                startActivity(editProfileIntent);
            }
        });

//        imageViewProfilePic.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, REQUEST_CODE_GALLERY);
////                String userName = loginID;
////                byte[] profilePic = imageViewToByte(imageViewProfilePic);
////                userProfilePicDb.addProfilePic(userName, profilePic);
//            }
//
//            private byte[] imageViewToByte(ImageView image) {
//                Bitmap bitmap = ((BitmapDrawable)image.getDrawable()).getBitmap();
//                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//                bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
//                byte[] byteArray = byteArrayOutputStream.toByteArray();
//                return byteArray;
//            }
//        });




    }

//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        if (requestCode == REQUEST_CODE_GALLERY){
//            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                Intent galleryIntent = new Intent(Intent.ACTION_PICK);
//                galleryIntent.setType("image/*");
//                startActivityForResult(galleryIntent, REQUEST_CODE_GALLERY);
//            } else {
//                Toast.makeText(getContext(), "You don't have the permission to access file.", Toast.LENGTH_SHORT);
//            }
//            return;
//        }
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//    }

//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        ImageView imageViewProfilePic = getView().findViewById(R.id.imageViewProfilePic);
//        Uri uri = data.getData();
//        try {
//            InputStream inputStream = getActivity().getContentResolver().openInputStream(uri);
//            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
//            imageViewProfilePic.setImageBitmap(bitmap);
//
//        } catch (FileNotFoundException f1) {
//            f1.printStackTrace();
//        }
//        super.onActivityResult(requestCode, resultCode, data);
//    }

//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        ImageView imageViewProfilePic = getView().findViewById(R.id.imageViewProfilePic);
//        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && data != null) {
//            Uri selectedImage = data.getData();
//            imageViewProfilePic.setImageURI(selectedImage);
//        }
//    }
}
